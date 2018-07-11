package es.udc.fic.tfg.expense;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.Principal;

@Controller
public class ExpenseDetailsController {

    private static final String EXPENSEDETAILS_VIEW_NAME = "expense/expenseDetails";

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("expense/expenseDetails/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public String expense(@PathVariable("id") Long id, Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith,
                          Principal principal) {
        Account account = accountRepository.findOneByEmail(principal.getName());
        Expense expense = expenseService.findOneById(id);
        model.addAttribute("expense",expense);

       return EXPENSEDETAILS_VIEW_NAME;
    }
}
