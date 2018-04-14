package es.udc.fic.tfg.horse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import es.udc.fic.tfg.account.AccountService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.udc.fic.tfg.account.Account;

@Service
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HorseService {

    @Autowired
    private HorseRepository horseRepository;

    @Autowired
    private AccountService accountService;

//    @PostConstruct
//    protected void initialize() throws ParseException {
//
//        String s = "07/07/2005";
//        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
//        Date date = format.parse(s);
//
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        String dateInString = "07/07/2013";
//
//        Date date2 = formatter.parse(dateInString);
//
//        List<Horse> horses = new ArrayList<Horse>();
//        List<Horse> horses2 = new ArrayList<Horse>();
//        accountService.save(new Account("user@udc.es", "User", "User", "demo", "ROLE_USER", "666666666",horses));
//        accountService.save(new Account("admin@udc.es", "Admin", "Admin", "admin", "ROLE_ADMIN", "617617617",horses2));
//
//
//        /*Owners*/
//        Account a = accountService.findByEmail("user@udc.es");
//        List<Account> owners = new ArrayList<Account>();
//        owners.add(a);
//
//        save(new Horse("Cintia", "Cintia", "Holsteiner", date2, GenderType.MARE, FurType.DARKBAY,
//                MarkingsType.BLAZE, "Cassini I", "Grundyman", owners, "079909", "1234"));
//        save(new Horse("Chantré", "Chantré 34", "Mecklenburg", date2, GenderType.GELDING, FurType.BAY,
//                MarkingsType.STRIPE, "Chandon", "Lord Kemm", owners, "030378", "1233"));
//
//
//    }

    @Transactional
    public Horse save(Horse horse) {
        horseRepository.save(horse);
        return horse;
    }

    public Horse findOneById(Long horseid) {
        Horse horse = horseRepository.findOneByHorseId(horseid);
        return horse;
    }

}
