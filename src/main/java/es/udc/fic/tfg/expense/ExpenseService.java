package es.udc.fic.tfg.expense;

import es.udc.fic.tfg.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.udc.fic.tfg.activity.Activity;
import es.udc.fic.tfg.activity.ActivityRepository;
import es.udc.fic.tfg.training.TrainingRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    public ArrayList<BigDecimal> anualExpenses(Account account) {
        int i;
        Date d = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int y = calendar.get(Calendar.YEAR);
        ArrayList<BigDecimal> monthExpenses = new ArrayList<>();
        for (i=0;i<12;i++) {
            monthExpenses.add(i, new BigDecimal(0));
        }
        System.out.println("month \n\n"+monthExpenses);

        List<Expense> myExpenses = expenseRepository.findByConsumer(account);

        for (Expense e : myExpenses) {
            Date date = e.getExpensedate();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            if (year == y) {
                    monthExpenses.set(month, monthExpenses.get(month).add(e.getAmount()));
            }
        }
        return monthExpenses;
    }

}



