package es.udc.fic.tfg.training;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountRepository;
import es.udc.fic.tfg.account.AccountService;
import es.udc.fic.tfg.expense.Expense;
import es.udc.fic.tfg.expense.ExpenseService;
import es.udc.fic.tfg.expense.SpringMailSender;
import es.udc.fic.tfg.horse.Horse;
import es.udc.fic.tfg.horse.HorseRepository;
import es.udc.fic.tfg.horse.HorseService;
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
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

@Controller
public class NewTrainingController {

    private static final String NEWTRAINING_VIEW_NAME = "training/newTraining";

    @Autowired
    private HorseRepository horseRepository;

    @Autowired
    private HorseService horseService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private ExpenseService expenseService;

    private Errors errors;

    private RedirectAttributes ra;

    @Autowired
    private SpringMailSender springMailSender;

    @GetMapping("newTraining")
    String newTraining(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith,
                       Principal principal) {
        model.addAttribute(new NewTrainingForm());

        Account rider = accountRepository.findOneByEmail(principal.getName());

        /*Autocompletado nombres de Caballos*/
        List<String> names = new ArrayList<>();

        for (Horse h : horseRepository.findByRider(rider)) {
            names.add(h.getNickname());
        }

        model.addAttribute("list", names);
        if (Ajax.isAjaxRequest(requestedWith)) {
            return NEWTRAINING_VIEW_NAME.concat(" :: newTrainingForm");
        }
        return NEWTRAINING_VIEW_NAME;
    }

    @PostMapping("newTraining")
    String newTraining(@Valid @ModelAttribute NewTrainingForm newTrainingForm, Errors errors, RedirectAttributes ra, Principal principal) {
        this.errors = errors;
        this.ra = ra;
        if (errors.hasErrors()) {
            return NEWTRAINING_VIEW_NAME;
        }

        if(principal!=null) {
            Account user = accountRepository.findOneByEmail(principal.getName());
            Training training = newTrainingForm.createTraining();
            training.setTraininguser(user);

            /*Asignar caballo con autocompletado*/
            String horseName = newTrainingForm.getTraininghorse();

            for (Horse horse : horseRepository.findByRider(user)) {
                if((horse.getNickname().equals(horseName))) {
                    training.setTraininghorse(horse);
                }
            }

            /*Crear nuevo gasto*/
            String amountText = newTrainingForm.getTrainingexpense();
            BigDecimal amount = new BigDecimal(amountText);
            if (amount.compareTo(BigDecimal.ZERO) == 1) {
                Expense expense = new Expense("", amount, training.getTrainingdate(), user, training.getTraininghorse());
                expense.setTitle("Gasto Entrenamiento: "+training.getType()+" asociado al caballo: " + training.getTraininghorse().getNickname());
                Expense e = expenseService.save(expense);
                training.setTrainingexpense(e);

                String message = "Ha registrado correctamente el pago: "+e.getTitle()+"\n"+"Coste del pago: "+e.getAmount()+" eur\n"+
                        "Caballo:" + e.getHorseexpense().getNickname();
                springMailSender.sendMail("patriciatfg1@gmail.com", user.getEmail(),"MyBarnAPP: Pago Registrado",message);

            }

            Training t = trainingService.save(training);
            horseService.addTrainingToHorse(t.getTraininghorse(),t);
            accountService.addTrainingToAccount(t.getTraininguser(),t);
        }
        return "redirect:/";
    }



}
