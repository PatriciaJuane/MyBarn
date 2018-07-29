package es.udc.fic.tfg.activity;

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
import java.util.Date;
import java.util.List;

@Controller
public class MyActivitiesController {

    private static final String MYACTIVITIES_VIEW_NAME = "activity/myActivities";

    private String horsename;
    private Horse horse;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private HorseRepository horseRepository;

    @GetMapping("myActivities")
    public String myActivities(Model m, Principal principal,  @RequestParam(name = "horsename", required = false) String horsename,
                               @RequestParam(name="activitydate", required = false) Date activitydate) {

        m.addAttribute(new MyActivitiesForm());

        Account user = accountService.findByEmail(principal.getName());

        Pageable pageable = new PageRequest(0,5,Sort.Direction.DESC,"activitydate");
        /*Para filtrar por caballo*/
        this.horse=null;
        this.horse=null;
        if (horsename!=null) {
            Horse h = horseRepository.findOneByNickname(horsename);
            this.horse = h;
        }


        if((activitydate==null) &&(horsename==null)) {
            m.addAttribute("activities",activityRepository.findByActivityuser(user,pageable));
        }
        else if(horsename==null) {
            m.addAttribute("activities", activityRepository.findByActivityuserAndActivitydate(user, activitydate, pageable));
        }
        else if(activitydate == null){
            m.addAttribute("activities", activityRepository.findByActivityuserAndActivityhorse(user, this.horse, pageable));
        }
        else
            m.addAttribute("activities", activityRepository.findByActivityuserAndActivityhorseAndActivitydate(user, this.horse, activitydate,pageable));


        m.addAttribute("activities", activityRepository.findByActivityuserAndActivityhorse(user,this.horse,pageable));

            m.addAttribute("activities", activityRepository.findByActivityuser(user,pageable));


        /*Autocompletado nombres de Caballos*/
        List<String> names = new ArrayList<>();

        for (Horse ho : horseRepository.findByRider(user)) {
            names.add(ho.getNickname());
        }
        m.addAttribute("list", names);

        return MYACTIVITIES_VIEW_NAME;
    }

    @GetMapping("myActivities/{page}")
    public String myActivities(Model m, Principal principal, @PathVariable("page") int pageNum,
                               @RequestParam(name = "horsename", required = false) String horsename,
                               @RequestParam(name="activitydate", required = false) Date activitydate) {
        m.addAttribute(new MyActivitiesForm());

        Account user = accountService.findByEmail(principal.getName());

        Pageable pageable = new PageRequest(pageNum,5,Sort.Direction.DESC,"activitydate");

        if((activitydate==null) &&(horsename==null)) {
            m.addAttribute("activities",activityRepository.findByActivityuser(user,pageable));
        }else if(horsename==null) {
            m.addAttribute("activities", activityRepository.findByActivityuserAndActivitydate(user, activitydate, pageable));
        }
        else if(activitydate == null){
            m.addAttribute("activities", activityRepository.findByActivityuserAndActivityhorse(user, this.horse, pageable));
        }
        else
            m.addAttribute("activities", activityRepository.findByActivityuserAndActivityhorseAndActivitydate(user, this.horse, activitydate,pageable));

        /*Autocompletado nombres de Caballos*/
        List<String> names = new ArrayList<>();

        for (Horse h : horseRepository.findByRider(user)) {
            names.add(h.getNickname());
        }
        m.addAttribute("list", names);

        return MYACTIVITIES_VIEW_NAME;
    }

    @PostMapping("myActivities")
    public String myActivities(Model m, Principal principal,
                               @Valid @ModelAttribute MyActivitiesForm myActivitiesForm) {

        String horsename = myActivitiesForm.getHorsename();
        Date activitydate = myActivitiesForm.getActivitydate();
        Horse h = null;
        if (horsename!=null){
             h = horseRepository.findOneByNickname(horsename);
        }
        Account user = accountService.findByEmail(principal.getName());

        Pageable pageable = new PageRequest(0,5,Sort.Direction.DESC,"activitydate");

        if((activitydate==null) &&(h==null)) {
            m.addAttribute("activities",activityRepository.findByActivityuser(user,pageable));
        }else if(h==null) {
            m.addAttribute("activities", activityRepository.findByActivityuserAndActivitydate(user, activitydate, pageable));
        }
        else if(activitydate == null){
            m.addAttribute("activities", activityRepository.findByActivityuserAndActivityhorse(user, h, pageable));
        }
        else
            m.addAttribute("activities", activityRepository.findByActivityuserAndActivityhorseAndActivitydate(user, h, activitydate, pageable));

        /*Autocompletado nombres de Caballos*/
        List<String> names = new ArrayList<>();

        for (Horse ho : horseRepository.findByRider(user)) {
            names.add(ho.getNickname());
        }
        m.addAttribute("list", names);

        m.addAttribute(new MyActivitiesForm());
        return MYACTIVITIES_VIEW_NAME;
    }
}
