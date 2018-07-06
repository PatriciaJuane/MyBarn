package es.udc.fic.tfg.horse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountService;
import java.security.Principal;


@Controller
public class RiddenHorsesController {

    private static final String RIDDENHORSES_VIEW_NAME = "horse/riddenHorses";

    @Autowired
    private HorseService horseService;
    
    @Autowired
    private AccountService accountService;

    @GetMapping("riddenHorses")
    // @ResponseStatus(value = HttpStatus.OK)
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String riddenHorses(Model m, Principal principal) {
    	 Account owner = accountService.findByEmail(principal.getName());
         
    	m.addAttribute("horses", owner.getHorsesRidden());
        return RIDDENHORSES_VIEW_NAME;
    }

}
