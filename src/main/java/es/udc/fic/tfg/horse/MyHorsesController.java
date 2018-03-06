package es.udc.fic.tfg.horse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class MyHorsesController {

    private static final String MYHORSES_VIEW_NAME = "horse/myHorses";

    @Autowired
    private HorseService horseService;

    @GetMapping("myHorses")
   // @ResponseStatus(value = HttpStatus.OK)
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String myHorses() {
      //  Account account = accountRepository.findOneByEmail(principal.getName());

       // m.addAttribute("horsesList", horses);

        return MYHORSES_VIEW_NAME;
    }

}
