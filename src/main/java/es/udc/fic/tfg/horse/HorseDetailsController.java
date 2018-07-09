package es.udc.fic.tfg.horse;

import javax.validation.Valid;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountRepository;
import es.udc.fic.tfg.newHorse.NewHorseForm;
import es.udc.fic.tfg.signup.SignupForm;
import es.udc.fic.tfg.support.web.Ajax;
import es.udc.fic.tfg.support.web.MessageHelper;
import es.udc.fic.tfg.userDetails.ProfilePicForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HorseDetailsController {

    private static final String HORSEDETAILS_VIEW_NAME = "horse/horseDetails";

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private HorseService horseService;

    @GetMapping("horse/horseDetails/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public String horse(@PathVariable("id") Long id, Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith,
                        Principal principal) {
        Account account = accountRepository.findOneByEmail(principal.getName());
        model.addAttribute("account",account);
        Horse horse = horseService.findOneById(id);
        model.addAttribute("horse", horse);
        model.addAttribute(new NewHorseForm());
        model.addAttribute(new ProfilePicHorseForm());

        /*if (Ajax.isAjaxRequest(requestedWith)) {
            return HORSEDETAILS_VIEW_NAME.concat(" :: newHorseForm");
        } */
        return HORSEDETAILS_VIEW_NAME;
    }

    @PostMapping("horse/horseDetails/{id}")
    public String horse(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute NewHorseForm newhorseForm,
                        Errors errors, RedirectAttributes ra, Principal principal) throws ParseException {

        /*if (errors.hasErrors()) {
            return HORSEDETAILS_VIEW_NAME;
        }*/
        Horse local = newhorseForm.createHorse();
        horseService.update(id, local);

        Account account = accountRepository.findOneByEmail(principal.getName());
        model.addAttribute("account",account);
        Horse horse = horseService.findOneById(id);
        model.addAttribute("horse", horse);
        model.addAttribute(new NewHorseForm());
		model.addAttribute(new ProfilePicHorseForm());
        return "horse/horseDetails";
    }
    
    @PostMapping("horse/horseDetails/changeProfilePic/{id}")
	public String changeProfilePic(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute ProfilePicHorseForm profilePicHorseForm,
			Principal principal) {
    	Horse horse = horseService.findOneById(id);
		String newPic = profilePicHorseForm.changePhoto(horse);
		Horse changed = horseService.changeProfilePic(horse, newPic);
        Account account = accountRepository.findOneByEmail(principal.getName());
        model.addAttribute("account",account);
		model.addAttribute("horse", changed);
		model.addAttribute(new NewHorseForm());
		model.addAttribute(new ProfilePicHorseForm());
		return "horse/horseDetails";
	}

}


