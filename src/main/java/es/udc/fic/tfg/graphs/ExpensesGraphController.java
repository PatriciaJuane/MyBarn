package es.udc.fic.tfg.graphs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpensesGraphController {

    @GetMapping("/expense/expensesGraph")
    String expensesGraph() {

        return "expense/expensesGraph";
    }

}
