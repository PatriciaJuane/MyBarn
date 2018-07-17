package es.udc.fic.tfg.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.udc.fic.tfg.activity.Activity;
import es.udc.fic.tfg.activity.ActivityRepository;
import es.udc.fic.tfg.training.TrainingRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    
    @Transactional
    public Expense save(Expense expense){
        expenseRepository.save(expense);
        return expense;
    }

    public Expense findOneById(Long expenseid) {
        Expense expense = expenseRepository.findOneByExpenseid(expenseid);
        return expense;
    }
    
    public void delete(Expense expense) {
    	expenseRepository.delete(expense);
    }



}
