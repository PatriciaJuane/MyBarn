package es.udc.fic.tfg.expense;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountRepository;
import es.udc.fic.tfg.activity.Activity;
import es.udc.fic.tfg.activity.ActivityRepository;
import es.udc.fic.tfg.training.Training;
import es.udc.fic.tfg.training.TrainingRepository;

@Controller
public class ExpenseDetailsController {

	private static final String EXPENSEDETAILS_VIEW_NAME = "expense/expenseDetails";

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ExpenseService expenseService;

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private TrainingRepository trainingRepository;

	@GetMapping("expense/expenseDetails/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public String expense(@PathVariable("id") Long id, Model model,
			@RequestHeader(value = "X-Requested-With", required = false) String requestedWith, Principal principal) {
		Account account = accountRepository.findOneByEmail(principal.getName());
		Expense expense = expenseService.findOneById(id);
		model.addAttribute("expense", expense);

		return EXPENSEDETAILS_VIEW_NAME;
	}

	@GetMapping("expense/expenseDetails/delete/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public String expense(@PathVariable("id") Long id, Model model,
			@RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {
		Expense expense = expenseService.findOneById(id);
		Activity a = activityRepository.findByActivityexpense(expense);
		if (a != null) {
			a.setActivityexpense(null);
			activityRepository.save(a);
		}
		
		Training t = trainingRepository.findByTrainingexpense(expense);
		if (t!=null) {
			t.setTrainingexpense(null);
			trainingRepository.save(t);
		}
		expenseService.delete(expense);
		return "/home/homeSignedIn";
	}
}
