package es.udc.fic.tfg.activity;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountRepository;
import es.udc.fic.tfg.expense.Expense;
import es.udc.fic.tfg.expense.ExpenseService;
import es.udc.fic.tfg.horse.Horse;
import es.udc.fic.tfg.horse.HorseRepository;
import es.udc.fic.tfg.support.web.Ajax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.security.Principal;
import javax.validation.Valid;

@Controller
public class NewActivityController {

    private static final String NEWACTIVITY_VIEW_NAME = "activity/newActivity";

    @Autowired
    private HorseRepository horseRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ExpenseService expenseService;

    private Errors errors;

    private RedirectAttributes ra;

    @GetMapping("newActivity")
    String newActivity(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith,
                       Principal principal) {
        model.addAttribute(new NewActivityForm());

        Account rider = accountRepository.findOneByEmail(principal.getName());

        /*Autocompletado nombres de Caballos*/
        List<String> names = new ArrayList<>();

        for (Horse h : horseRepository.findByRider(rider)
                ) {
            names.add(h.getNickname());
        }

        model.addAttribute("list", names);
        if (Ajax.isAjaxRequest(requestedWith)) {
            return NEWACTIVITY_VIEW_NAME.concat(" :: newActivityForm");
        }
        return NEWACTIVITY_VIEW_NAME;
    }

    @PostMapping("newActivity")
    String newActivity(@Valid @ModelAttribute NewActivityForm newActivityForm, Errors errors, RedirectAttributes ra, Principal principal) {
        this.errors = errors;
        this.ra = ra;
        if (errors.hasErrors()) {
            return NEWACTIVITY_VIEW_NAME;
        }

        if(principal!=null) {
            Account user = accountRepository.findOneByEmail(principal.getName());
            Activity activity = newActivityForm.createActivity();
            activity.setActivityuser(user);

            /*Asignar caballo con autocompletado*/
            String horseName = newActivityForm.getActivityhorse();

            for (Horse horse : horseRepository.findByRider(user)) {
                if((horse.getNickname().equals(horseName))) {
                    activity.setActivityhorse(horse);
                }
            }

            /*Crear nuevo gasto*/
            String amountText = newActivityForm.getActivityexpense();
            BigDecimal amount = new BigDecimal(amountText);
            if (amount.compareTo(BigDecimal.ZERO) == 1) {
                Expense expense = new Expense("", amount, activity.getActivitydate(), user, activity.getActivityhorse());
                expense.setTitle("Gasto Actividad: "+activity.getType()+" asociada al caballo: " + activity.getActivityhorse().getNickname());
                Expense e = expenseService.save(expense);
                activity.setActivityexpense(e);
            }

            Activity a = activityService.save(activity);
        }
        return "redirect:/";
    }


}
