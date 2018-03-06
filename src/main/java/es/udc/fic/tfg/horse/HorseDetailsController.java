package es.udc.fic.tfg.horse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class HorseDetailsController {

    private static final String HORSEDETAILS_VIEW_NAME = "horse/horseDetails";

    @Autowired
    private HorseService horseService;

    @GetMapping("horse/horseDetails/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public String horse(@PathVariable("id") Long id, Model model) {
      Horse horse = horseService.findOneById(id);
        model.addAttribute("horse",horse);
        return HORSEDETAILS_VIEW_NAME;
    }
}
