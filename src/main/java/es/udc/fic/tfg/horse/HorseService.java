package es.udc.fic.tfg.horse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.udc.fic.tfg.account.Account;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HorseService {

    @Autowired
    private HorseRepository horseRepository;

    @PostConstruct
    protected void initialize() throws ParseException {

        //Account a = new Account("patricia@udc.es", "Patricia", "Juane", "demo", "ROLE_USER", "666666666");

        String s = "07/07/2005";
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = format.parse(s);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = "07/07/2013";

        Date date2 = formatter.parse(dateInString);


        save(new Horse("Cintia", "Cintia", "Holsteiner", date2, "Mare", "Dark bay",
                "large marking", "Cassini I", "Grundyman", "079909", "1234"));
        save(new Horse("Chantré", "Chantré 34", "Mecklenburg", date2, "Gelding", "Bay",
                "thin marking", "Chandon", "Lord Kemm", "030378", "1233"));


    }

    @Transactional
    public Horse save(Horse horse) {
        horseRepository.save(horse);
        return horse;
    }

    public Horse findOneById(Long id) {
        Horse horse = horseRepository.findOneById(id);
        return horse;
    }

    /*public List<Horse> findByUserName(Account owner){

        return horseRepository.findByOwner();
    }*/

}
