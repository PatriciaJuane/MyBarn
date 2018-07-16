package es.udc.fic.tfg.expense;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountService;
import es.udc.fic.tfg.horse.Horse;
import es.udc.fic.tfg.horse.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import javax.validation.Valid;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyExpensesController {

    private static final String MYEXPENSES_VIEW_NAME = "expense/myExpenses";

    private String horsename;
    private Horse horse;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private HorseRepository horseRepository;

    @GetMapping("myExpenses")
    public String myExpenses(Model m, Principal principal,  @RequestParam(name = "horsename", required = false) String horsename) {

        m.addAttribute(new MyExpensesForm());

        Account consumer = accountService.findByEmail(principal.getName());

        Pageable pageable = new PageRequest(0,5,Sort.Direction.DESC,"expensedate");
        /*Para filtrar por caballo*/
        this.horse=null;
        if (horsename!=null){
            Horse h = horseRepository.findOneByNickname(horsename);
            this.horse = h;
            m.addAttribute("expenses", expenseRepository.findByConsumerAndHorseexpense(consumer,this.horse,pageable));

        } else
            m.addAttribute("expenses", expenseRepository.findByConsumer(consumer,pageable));


        /*Autocompletado nombres de Caballos*/
        List<String> names = new ArrayList<>();

        for (Horse ho : horseRepository.findByOwner(consumer)) {
            names.add(ho.getNickname());
        }
        m.addAttribute("list", names);

        return MYEXPENSES_VIEW_NAME;
    }

    @GetMapping("myExpenses/{page}")
    public String myExpenses(Model m, Principal principal, @PathVariable("page") int pageNum,
                               @RequestParam(name = "horsename", required = false) String horsename) {
        m.addAttribute(new MyExpensesForm());

        Account consumer = accountService.findByEmail(principal.getName());

        Pageable pageable = new PageRequest(pageNum,5,Sort.Direction.DESC,"expensedate");

        if(horsename!=null) {
            m.addAttribute("expenses", expenseRepository.findByConsumerAndHorseexpense(consumer, this.horse, pageable));
        }else
            m.addAttribute("expenses",expenseRepository.findByConsumer(consumer,pageable));

        /*Autocompletado nombres de Caballos*/
        List<String> names = new ArrayList<>();

        for (Horse h : horseRepository.findByOwner(consumer)) {
            names.add(h.getNickname());
        }
        m.addAttribute("list", names);

        return MYEXPENSES_VIEW_NAME;
    }


    @PostMapping("myExpenses")
    public String myExpenses(Model m, Principal principal,
                               @Valid @ModelAttribute MyExpensesForm myExpensesForm) {

        String horsename = myExpensesForm.getHorsename();
        Horse h = null;
        if (horsename!=null){
            h = horseRepository.findOneByNickname(horsename);
        }
        Account consumer = accountService.findByEmail(principal.getName());

        Pageable pageable = new PageRequest(0,5,Sort.Direction.DESC,"expensedate");

        m.addAttribute("expenses", expenseRepository.findByConsumerAndHorseexpense(consumer,h,pageable));

        /*Autocompletado nombres de Caballos*/
        List<String> names = new ArrayList<>();

        for (Horse ho : horseRepository.findByOwner(consumer)) {
            names.add(ho.getNickname());
        }
        m.addAttribute("list", names);

        m.addAttribute(new MyExpensesForm());
        return MYEXPENSES_VIEW_NAME;
    }

}
