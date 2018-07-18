package es.udc.fic.tfg.expense;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MyExpensesForm {

    private String horsename;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date expensedate;

    public String getHorsename() { return horsename; }

    public void setHorsename(String horsename) {
        this.horsename = horsename;
    }

    public Date getExpensedate() { return expensedate; }

    public void setExpensedate(Date expensedate) { this.expensedate = expensedate; }

}
