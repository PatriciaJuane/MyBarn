package es.udc.fic.tfg.newHorse;

import javax.validation.Valid;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountRepository;
import es.udc.fic.tfg.account.AccountService;
import es.udc.fic.tfg.expense.Expense;
import es.udc.fic.tfg.expense.ExpenseService;
import es.udc.fic.tfg.horse.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.udc.fic.tfg.support.web.Ajax;
import es.udc.fic.tfg.support.web.MessageHelper;
import es.udc.fic.tfg.support.web.*;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.security.Principal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
class NewHorseController {

    private static final String NEWHORSE_VIEW_NAME = "newHorse/newHorse";

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private HorseService horseService;

    @Autowired
    private ExpenseService expenseService;

    private Errors errors;

    private RedirectAttributes ra;

    @GetMapping("newHorse")
    String newHorse(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {
        model.addAttribute(new NewHorseForm());

        List<String> names = new ArrayList<>();

        for (Account a : accountRepository.findByRider()
             ) {
            names.add(a.getFirstname()+" "+a.getLastname());
        }

        model.addAttribute("list", names);

        if (Ajax.isAjaxRequest(requestedWith)) {
            return NEWHORSE_VIEW_NAME.concat(" :: newHorseForm");
        }
        return NEWHORSE_VIEW_NAME;
    }

    @PostMapping("newHorse")
    String newHorse(@Valid @ModelAttribute NewHorseForm newhorseForm, Errors errors, RedirectAttributes ra, Principal principal)
    throws ParseException{
        this.errors = errors;
        this.ra = ra;
        if (errors.hasErrors()) {
            return NEWHORSE_VIEW_NAME;
        }

        if(principal!=null) {
            Account owner = accountRepository.findOneByEmail(principal.getName());
            Horse horse = newhorseForm.createHorse();

            /*Asignar jinete con autocompletado*/
            String riderName = newhorseForm.getRider();
            String[] splited = riderName.split("\\s+");
            String riderFirstname = splited[0];
            String riderLastname = splited[1];

            for (Account account : accountRepository.findByRider()) {
                if((account.getFirstname().equals(riderFirstname))
                        && (account.getLastname().equals(riderLastname))) {
                    horse.setRider(account);
                }
            }
            
            if (horse.getRider()!=null) {
            	Account account = accountRepository.findOneByEmail(horse.getRider().getEmail());
                accountService.addHorseToAccount(account, horse);
            } /*Añado el caballo a la lista de caballos montados por ESE JINETE*/

            Horse saved = horseService.save(horse, owner);

            /*Crear gasto asociado al caballo*/
            String amountText = newhorseForm.getExpenseAmount();
            BigDecimal amount = new BigDecimal(amountText);
            if (amount.compareTo(BigDecimal.ZERO) == 1) {
                Date ahora = new Date();
                Expense expense = new Expense("", amount, ahora, owner, saved);
                expense.setTitle("Gasto mensual asociado al caballo: " + saved.getNickname());
                expenseService.save(expense);
            }
        }
        return "redirect:/";
    }
}