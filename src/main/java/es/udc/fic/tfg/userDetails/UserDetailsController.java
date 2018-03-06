package es.udc.fic.tfg.userDetails;

import es.udc.fic.tfg.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.security.Principal;

@Controller
public class UserDetailsController {

    private static final String USERDETAILS_VIEW_NAME = "user/userDetails";

    @Autowired
    private AccountService accountService;


    @GetMapping("user/userDetails")
    @ResponseStatus(value = HttpStatus.OK)
   // @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String account(Principal principal, Model model) {
        if (principal!=null) {
            Account a = accountService.findByEmail(principal.getName());
            model.addAttribute("account",a);
        }
        return USERDETAILS_VIEW_NAME;
    }

}
