package es.udc.fic.tfg.horse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    
    @Autowired
    private HorseRepository horseRepository;

    @GetMapping("riddenHorses")
    // @ResponseStatus(value = HttpStatus.OK)
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String riddenHorses(Model m, Principal principal) {
    	 Account rider = accountService.findByEmail(principal.getName());
         
    	 Pageable pageable = new PageRequest(0,2,Sort.Direction.DESC,"nickname");
         
     	m.addAttribute("horses", horseRepository.findByRider(rider,pageable));
    	 
    	//m.addAttribute("horses", owner.getHorsesRidden());
        return RIDDENHORSES_VIEW_NAME;
    }
    
    @GetMapping("riddenHorses/{page}")
    // @ResponseStatus(value = HttpStatus.OK)
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String riddenHorses(Model m, Principal principal, @PathVariable("page") int pageNum) {
        Account rider = accountService.findByEmail(principal.getName());

        Pageable pageable = new PageRequest(pageNum,2,Sort.Direction.DESC,"nickname");

        m.addAttribute("horses", horseRepository.findByRider(rider,pageable));
        return RIDDENHORSES_VIEW_NAME;
    }

}
