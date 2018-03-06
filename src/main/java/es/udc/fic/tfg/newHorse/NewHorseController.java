package es.udc.fic.tfg.newHorse;

import javax.validation.Valid;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountRepository;
import es.udc.fic.tfg.horse.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.udc.fic.tfg.horse.Horse;
import es.udc.fic.tfg.horse.HorseService;
import es.udc.fic.tfg.support.web.Ajax;
import es.udc.fic.tfg.support.web.MessageHelper;

import java.security.Principal;
import java.text.ParseException;

@Controller
class NewHorseController {

    private static final String NEWHORSE_VIEW_NAME = "newHorse/newHorse";

    @Autowired
    private HorseRepository horseRepository;

    @Autowired
    private HorseService horseService;
    private NewHorseForm newhorseForm;
    private Errors errors;

    private RedirectAttributes ra;

    @GetMapping("newHorse")
    String newHorse(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {
        model.addAttribute(new NewHorseForm());
        if (Ajax.isAjaxRequest(requestedWith)) {
            return NEWHORSE_VIEW_NAME.concat(" :: newHorseForm");
        }
        return NEWHORSE_VIEW_NAME;
    }

    @PostMapping("newHorse")
    String newHorse(@Valid @ModelAttribute NewHorseForm newhorseForm, Errors errors, RedirectAttributes ra)
    throws ParseException{
        this.newhorseForm = newhorseForm;
        this.errors = errors;
        this.ra = ra;
        if (errors.hasErrors()) {
            return NEWHORSE_VIEW_NAME;
        }
      /*  if(principal!=null) {
            Account owner = accountRepository.findOneByEmail(principal.getName());
            try {
                horseService.save(newhorseForm.createHorse(owner));
            }catch(ParseException e){
                e.printStackTrace();
            }
        } */
         horseService.save(newhorseForm.createHorse());
        MessageHelper.addSuccessAttribute(ra, "newHorse.success");
        return "redirect:/";
    }
}

