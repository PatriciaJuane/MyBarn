package es.udc.fic.tfg.expense;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class MyExpensesController {

    private static final String MYEXPENSES_VIEW_NAME = "expense/myExpenses";

    @Autowired
    private AccountService accountService;

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("myExpenses")
    // @ResponseStatus(value = HttpStatus.OK)
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String myExpenses(Model m, Principal principal) {
        Account consumer = accountService.findByEmail(principal.getName());

        Pageable pageable = new PageRequest(0,5,Sort.Direction.DESC,"expensedate");

        m.addAttribute("expenses", expenseRepository.findByConsumer(consumer,pageable));
        return MYEXPENSES_VIEW_NAME;
    }

    @GetMapping("myExpenses/{page}")
    public String myExpenses(Model m, Principal principal, @PathVariable("page") int pageNum) {
        Account consumer = accountService.findByEmail(principal.getName());

        Pageable pageable = new PageRequest(pageNum,5,Sort.Direction.DESC,"expensedate");

        m.addAttribute("expenses", expenseRepository.findByConsumer(consumer,pageable));
        return MYEXPENSES_VIEW_NAME;
    }
}
