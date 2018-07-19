package es.udc.fic.tfg.graphs;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountRepository;
import es.udc.fic.tfg.training.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;

@Controller
public class TrainingsGraphController {

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/training/trainingsGraph")
    String trainingsGraph(Model model, Principal principal) {

        Account account = accountRepository.findOneByEmail(principal.getName());
        ArrayList<Double> anual = trainingService.anualTrainings(account);

        model.addAttribute("anualTrainings",anual);
        return "training/trainingsGraph";
    }
}
