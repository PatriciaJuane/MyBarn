package es.udc.fic.tfg.horse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;


@Controller
public class MyHorsesController {

    private static final String MYHORSES_VIEW_NAME = "horse/myHorses";

    @Autowired
    private HorseService horseService;
    
    @Autowired
    private AccountService accountService;

    @Autowired
    private HorseRepository horseRepository;

    @GetMapping("myHorses")
    // @ResponseStatus(value = HttpStatus.OK)
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String myHorses(Model m, Principal principal) {
    	 Account owner = accountService.findByEmail(principal.getName());

    	 Pageable pageable = new PageRequest(0,2,Sort.Direction.DESC,"nickname");
         
    	m.addAttribute("horses", horseRepository.findByOwner(owner,pageable));
        return MYHORSES_VIEW_NAME;
    }

    @GetMapping("myHorses/{page}")
    // @ResponseStatus(value = HttpStatus.OK)
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String myHorses(Model m, Principal principal, @PathVariable("page") int pageNum) {
        Account owner = accountService.findByEmail(principal.getName());

        Pageable pageable = new PageRequest(pageNum,2,Sort.Direction.DESC,"nickname");

        m.addAttribute("horses", horseRepository.findByOwner(owner,pageable));
        return MYHORSES_VIEW_NAME;
    }

}
