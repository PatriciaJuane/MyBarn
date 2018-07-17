package es.udc.fic.tfg.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.udc.fic.tfg.expense.Expense;

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
}
