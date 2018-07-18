package es.udc.fic.tfg.graphs;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountRepository;
import es.udc.fic.tfg.expense.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;

@Controller
public class ExpensesGraphController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/expense/expensesGraph")
    String expensesGraph(Model model, Principal principal) {

        Account account = accountRepository.findOneByEmail(principal.getName());
        ArrayList<BigDecimal> anual = expenseService.anualExpenses(account);

        model.addAttribute("anualExpenses",anual);
        return "expense/expensesGraph";
    }

}
