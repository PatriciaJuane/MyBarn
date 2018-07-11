package es.udc.fic.tfg.expense;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountRepository;
import es.udc.fic.tfg.horse.Horse;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.validator.constraints.NotBlank;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewExpenseForm {

    private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";

    @Autowired
    private AccountRepository accountRepository;

    @NotBlank(message = NewExpenseForm.NOT_BLANK_MESSAGE)
    private String title;

    @NotBlank(message = NewExpenseForm.NOT_BLANK_MESSAGE)
    private String amount;

    private Account consumer;

    private String horseexpense;

    private Date expensedate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Account getConsumer() {
        return consumer;
    }

    public void setConsumer(Account consumer) {
        this.consumer = consumer;
    }

    public String getHorseexpense() {
        return horseexpense;
    }

    public void setHorseexpense(String horseexpense) {
        this.horseexpense = horseexpense;
    }

    public Date getExpensedate() {
        return expensedate;
    }

    public void setExpensedate(Date expensedate) {
        this.expensedate = expensedate;
    }

    public Expense createExpense() {

        String amountText = getAmount();
        BigDecimal amount = new BigDecimal(amountText);
        if (amount.compareTo(BigDecimal.ZERO) == 1) {
            Date ahora = new Date();
            return new Expense(getTitle(), amount, ahora, getConsumer(),null);
        }
        else return null;
    }

}
