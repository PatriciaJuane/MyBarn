package es.udc.fic.tfg.activity;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountRepository;
import es.udc.fic.tfg.expense.Expense;
import es.udc.fic.tfg.training.Training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.Principal;

@Controller
public class ActivityDetailsController {
    private static final String ACTIVITYDETAILS_VIEW_NAME = "activity/activityDetails";

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ActivityService activityService;

    @GetMapping("activity/activityDetails/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public String activity(@PathVariable("id") Long id, Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith,
                          Principal principal) {
        Account account = accountRepository.findOneByEmail(principal.getName());
        Activity activity = activityService.findOneById(id);
        model.addAttribute("activity",activity);

        return ACTIVITYDETAILS_VIEW_NAME;
    }
    
	@GetMapping("activity/activityDetails/delete/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public String expense(@PathVariable("id") Long id, Model model,
			@RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {
		Activity activity = activityService.findOneById(id);
	
		activityService.delete(activity);
		return "/home/homeSignedIn";
	}


}
