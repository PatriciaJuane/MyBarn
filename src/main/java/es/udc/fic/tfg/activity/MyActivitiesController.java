package es.udc.fic.tfg.activity;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.security.Principal;

@Controller
public class MyActivitiesController {

    private static final String MYACTIVITIES_VIEW_NAME = "activity/myActivities";

    @Autowired
    private AccountService accountService;

    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping("myActivities")
    // @ResponseStatus(value = HttpStatus.OK)
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String myActivities(Model m, Principal principal) {
        Account user = accountService.findByEmail(principal.getName());

        Pageable pageable = new PageRequest(0,5,Sort.Direction.DESC,"activitydate");

        m.addAttribute("activities", activityRepository.findByActivityuser(user,pageable));
        return MYACTIVITIES_VIEW_NAME;
    }

    @GetMapping("myActivities/{page}")
    public String myActivities(Model m, Principal principal, @PathVariable("page") int pageNum) {
        Account user = accountService.findByEmail(principal.getName());

        Pageable pageable = new PageRequest(pageNum,5,Sort.Direction.DESC,"activitydate");

        m.addAttribute("activities", activityRepository.findByActivityuser(user,pageable));
        return MYACTIVITIES_VIEW_NAME;
    }
}
