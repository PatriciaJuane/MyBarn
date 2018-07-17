package es.udc.fic.tfg.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.udc.fic.tfg.activity.Activity;

import java.security.Principal;

@Controller
public class TrainingDetailsController {

    private static final String TRAININGDETAILS_VIEW_NAME = "training/trainingDetails";


    @Autowired
    private TrainingService trainingService;

    @GetMapping("training/trainingDetails/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public String training(@PathVariable("id") Long id, Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {

        Training training = trainingService.findOneById(id);
        model.addAttribute("training",training);

        return TRAININGDETAILS_VIEW_NAME;
    }
    
	@GetMapping("training/trainingDetails/delete/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public String expense(@PathVariable("id") Long id, Model model,
			@RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {
		Training training = trainingService.findOneById(id);
	
		trainingService.delete(training);
		return "/home/homeSignedIn";
	}
}
