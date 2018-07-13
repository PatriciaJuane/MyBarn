package es.udc.fic.tfg.training;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountService;
import es.udc.fic.tfg.horse.Horse;
import es.udc.fic.tfg.horse.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import javax.validation.Valid;

@Controller
public class MyTrainingsController {

    private static final String MYTRAININGS_VIEW_NAME = "training/myTrainings";

    private String horsename;
    private Horse horse;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private HorseRepository horseRepository;

    @GetMapping("myTrainings")
    public String myTrainings(Model m, Principal principal, @RequestParam(name = "horsename", required = false) String horsename) {

        m.addAttribute(new MyTrainingsForm());

        Account user = accountService.findByEmail(principal.getName());

        Pageable pageable = new PageRequest(0,5,Sort.Direction.DESC,"trainingdate");
        /*Para filtrar por caballo*/
        this.horse=null;
        if (horsename!=null){
            Horse h = horseRepository.findOneByNickname(horsename);
            this.horse = h;
            m.addAttribute("trainings", trainingRepository.findByTraininguserAndTraininghorse(user,this.horse,pageable));

        } else
            m.addAttribute("trainings", trainingRepository.findByTraininguser(user,pageable));


        /*Autocompletado nombres de Caballos*/
        List<String> names = new ArrayList<>();

        for (Horse ho : horseRepository.findByRider(user)) {
            names.add(ho.getNickname());
        }
        m.addAttribute("list", names);

        return MYTRAININGS_VIEW_NAME;
    }


    @GetMapping("myTrainings/{page}")
    public String myTrainings(Model m, Principal principal, @PathVariable("page") int pageNum,
                               @RequestParam(name = "horsename", required = false) String horsename) {
        m.addAttribute(new MyTrainingsForm());

        Account user = accountService.findByEmail(principal.getName());

        Pageable pageable = new PageRequest(pageNum,5,Sort.Direction.DESC,"trainingdate");

        if(horsename!=null) {
            m.addAttribute("trainings", trainingRepository.findByTraininguserAndTraininghorse(user, this.horse, pageable));
        }else
            m.addAttribute("trainings", trainingRepository.findByTraininguser(user,pageable));

        /*Autocompletado nombres de Caballos*/
        List<String> names = new ArrayList<>();

        for (Horse h : horseRepository.findByRider(user)) {
            names.add(h.getNickname());
        }
        m.addAttribute("list", names);

        return MYTRAININGS_VIEW_NAME;
    }

    @PostMapping("myTrainings")
    public String myTrainings(Model m, Principal principal,
                               @Valid @ModelAttribute MyTrainingsForm myTrainingsForm) {

        String horsename = myTrainingsForm.getHorsename();
        Horse h = null;
        if (horsename!=null){
            h = horseRepository.findOneByNickname(horsename);
        }
        Account user = accountService.findByEmail(principal.getName());

        Pageable pageable = new PageRequest(0,5,Sort.Direction.DESC,"trainingdate");

        m.addAttribute("trainings", trainingRepository.findByTraininguserAndTraininghorse(user,h,pageable));

        /*Autocompletado nombres de Caballos*/
        List<String> names = new ArrayList<>();

        for (Horse ho : horseRepository.findByRider(user)) {
            names.add(ho.getNickname());
        }
        m.addAttribute("list", names);

        m.addAttribute(new MyTrainingsForm());
        return MYTRAININGS_VIEW_NAME;
    }

}
