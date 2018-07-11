package es.udc.fic.tfg.expense;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountRepository;
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
import java.security.Principal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;

@Controller
public class NewExpenseController {

    private static final String NEWEXPENSE_VIEW_NAME = "expense/newExpense";

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private HorseRepository horseRepository;

    @Autowired
    private ExpenseService expenseService;

    private Errors errors;

    private RedirectAttributes ra;

    @GetMapping("newExpense")
    String newExpense(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith,
                      Principal principal) {

        model.addAttribute(new NewExpenseForm());

        Account owner = accountRepository.findOneByEmail(principal.getName());

        /*Autocompletado nombres de Caballos*/
        List<String> names = new ArrayList<>();

        for (Horse h : horseRepository.findByOwner(owner)
                ) {
            names.add(h.getNickname());
        }

        model.addAttribute("list", names);

        if (Ajax.isAjaxRequest(requestedWith)) {
            return NEWEXPENSE_VIEW_NAME.concat(" :: newExpenseForm");
        }
        return NEWEXPENSE_VIEW_NAME;
    }

    @PostMapping("newExpense")
    String newExpense(@Valid @ModelAttribute NewExpenseForm newexpenseForm, Errors errors, RedirectAttributes ra, Principal principal)
            throws ParseException {
        this.errors = errors;
        this.ra = ra;
        if (errors.hasErrors()) {
            return NEWEXPENSE_VIEW_NAME;
        }

        if(principal!=null) {
            Account owner = accountRepository.findOneByEmail(principal.getName());
            Expense expense = newexpenseForm.createExpense();
            expense.setConsumer(owner);

            /*Asignar caballo con autocompletado*/
            String horseName = newexpenseForm.getHorseexpense();

            for (Horse horse : horseRepository.findByOwner(owner)) {
                if((horse.getNickname().equals(horseName))) {
                    expense.setHorseexpense(horse);
                }
            }

            Expense e = expenseService.save(expense);
        }
        return "redirect:/";
    }
}
