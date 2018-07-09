package es.udc.fic.tfg.userDetails;

import es.udc.fic.tfg.account.*;
import es.udc.fic.tfg.account.AccountService;
import es.udc.fic.tfg.support.web.Ajax;
import es.udc.fic.tfg.support.web.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import es.udc.fic.tfg.signup.SignupForm;
import es.udc.fic.tfg.userDetails.ProfilePicForm;

import javax.validation.Valid;
import java.security.Principal;
import java.text.ParseException;

@Controller
public class UserDetailsController {

	private static final String USERDETAILS_VIEW_NAME = "user/userDetails";

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping("user/userDetails")
	@ResponseStatus(value = HttpStatus.OK)
	// @Secured({"ROLE_USER", "ROLE_ADMIN"})
	public String account(Principal principal, Model model,
			@RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {

		Account account = accountService.findByEmail(principal.getName());
		model.addAttribute("account", account);
		model.addAttribute(new SignupForm());
		model.addAttribute(new ProfilePicForm());
		/*if (Ajax.isAjaxRequest(requestedWith)) {
			return USERDETAILS_VIEW_NAME.concat(" :: signUpForm");
		}*/

		return USERDETAILS_VIEW_NAME;
	}

	@PostMapping("user/userDetails")
	public String account(Model model, @Valid @ModelAttribute SignupForm signupForm, Errors errors,
			RedirectAttributes ra, Principal principal) throws ParseException {
		/*
		 * if (errors.hasErrors()) { return USERDETAILS_VIEW_NAME; }
		 */

		Account a = accountRepository.findOneByEmail(principal.getName());
		Account local = signupForm.createAccount();
		accountService.update(local, a.getEmail());

		Account account = accountService.findByEmail(a.getEmail());
		model.addAttribute("account", account);
		model.addAttribute(new SignupForm());
		model.addAttribute(new ProfilePicForm());
		
		return "user/userDetails";
	}

	@PostMapping("user/userDetails/changeProfilePic")
	public String changeProfilePic(Model model, @Valid @ModelAttribute ProfilePicForm profilePicForm,
			Principal principal) {
		Account a = accountRepository.findOneByEmail(principal.getName());
		String newPic = profilePicForm.changePhoto(a);
		Account account = accountService.changeProfilePic(a, newPic);
		model.addAttribute("account", account);
		model.addAttribute(new SignupForm());
		model.addAttribute(new ProfilePicForm());
		
		return "user/userDetails";
	}

}
