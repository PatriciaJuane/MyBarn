package es.udc.fic.tfg.horse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.PostConstruct;

import es.udc.fic.tfg.account.AccountRepository;
import es.udc.fic.tfg.account.AccountService;
import java.security.Principal;

import es.udc.fic.tfg.activity.Activity;
import es.udc.fic.tfg.training.Training;
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

    @Autowired
    private AccountRepository accountRepository;

//    @PostConstruct
//    protected void initialize() throws ParseException {
//    }

    @Transactional
    public Horse save(Horse horse, Account account) {
        horse.setOwner(account);
        horseRepository.save(horse);
        List<Horse> horsesOwned = account.getHorsesOwned();
        horsesOwned.add(horse);
        account.setHorsesOwned(horsesOwned);
        accountRepository.save(account);
        return horse;
    }

    @Transactional
    public void update(Long id, Horse horse){
        Horse local = horseRepository.findOneByHorseId(id);
        local.setBirthDate(horse.getBirthdate());
        local.setBreed(horse.getBreed());
        local.setChipnumber(horse.getChipnumber());
        local.setDamnsire(horse.getDamnsire());
        local.setFur(horse.getFur());
        local.setLicensenumber(horse.getLicensenumber());
        local.setMarkings(horse.getMarkings());
        local.setName(horse.getName());
        local.setNickname(horse.getNickname());
        local.setSire(horse.getSire());
     //   local.setOwner(horse.getOwner()); //No se debe cambiar
        if (horse.getRider()!=null)
            local.setRider(horse.getRider());
        horseRepository.save(local);
    }

    public Horse findOneById(Long horseid) {
        Horse horse = horseRepository.findOneByHorseId(horseid);
        return horse;
    }

    public List<Horse> findAll(){
        return horseRepository.findAll();
    }
    
    @Transactional
	public Horse changeProfilePic(Horse horse, String newPic) {
		horse.setProfilePic(newPic);
		horseRepository.save(horse);
		return horse;
	}

	@Transactional
    public Horse addActivityToHorse(Horse horse, Activity activity) {
        List<Activity> horseActivities = horse.getHorseactivities();
        horseActivities.add(activity);
        horse.setHorseactivities(horseActivities);
        horseRepository.save(horse);
        return horse;
    }

    @Transactional
    public Horse addTrainingToHorse(Horse horse, Training training) {
        List<Training> horseTrainings = horse.getHorsetrainings();
        horseTrainings.add(training);
        horse.setHorsetrainings(horseTrainings);
        horseRepository.save(horse);
        return horse;
    }

}
