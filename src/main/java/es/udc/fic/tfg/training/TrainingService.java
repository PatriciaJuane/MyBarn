package es.udc.fic.tfg.training;

import es.udc.fic.tfg.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.udc.fic.tfg.expense.Expense;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    @Transactional
    public Training save(Training training){
        trainingRepository.save(training);
        return training;
    }

    public Training findOneById(Long trainingid) {
        Training training = trainingRepository.findOneByTrainingid(trainingid);
        return training;
    }
    
    public void delete(Training training) {
    	trainingRepository.delete(training);
    }

    public ArrayList<Double> anualTrainings(Account account) {
        int i;
        Date d = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int y = calendar.get(Calendar.YEAR);
        ArrayList<Double> monthHours = new ArrayList<>();
        for (i=0;i<12;i++) {
            monthHours.add(i, new Double(0));
        }

        List<Training> myTrainings = trainingRepository.findByTraininguser(account);

        for (Training t : myTrainings) {
            Date date = t.getTrainingdate();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            if (year == y) {
                String duracion = t.getDuration();

                String[] s =  duracion.split("h");
                Double hora = Double.parseDouble(s[0]);
               if (s.length>1) {
                   Double min;
                   if (s[1].contains("m")) {
                       String[] m = s[1].split("m");
                        min = Double.parseDouble(m[0]);
                   }
                   else {
                        min = Double.parseDouble(s[1]);
                   }
                   Double sesenta = new Double(60);
                   Double minuto = (min/sesenta);
                   monthHours.set(month, monthHours.get(month) + (hora + minuto));
               }else
                   monthHours.set(month, monthHours.get(month)+hora);
            }
        }
        return monthHours;
    }

}
