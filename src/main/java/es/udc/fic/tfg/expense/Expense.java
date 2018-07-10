package es.udc.fic.tfg.expense;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.horse.Horse;

@SuppressWarnings("serial")
@Entity
@Table(name = "expense")
public class Expense {

	@Id
	@GeneratedValue
	@Column(name = "expenseid")
	private Long expenseid;

	private String title;

	private BigDecimal amount;

	private Date expensedate;

	@ManyToOne(fetch = FetchType.EAGER)
	private Account consumer;

	@OneToOne(fetch = FetchType.EAGER)
	private Horse horseexpense;

	private Instant created;

	public Expense() {

	}

	public Expense(String title, BigDecimal amount, Date expensedate, Account consumer,
			Horse horseexpense) {
		this.title = title;
		this.amount = amount;
		this.expensedate = expensedate;
		this.consumer = consumer;
		this.horseexpense = horseexpense;
		this.created = Instant.now();
	}

	public Long getExpenseid() {
		return expenseid;
	}

	public void setExpenseid(Long expenseid) {
		this.expenseid = expenseid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getExpenseDate() {
		return expensedate;
	}

	public void setExpenseDate(Date expenseDate) {
		this.expensedate = expenseDate;
	}

	public Account getConsumer() {
		return consumer;
	}

	public void setConsumer(Account consumer) {
		this.consumer = consumer;
	}

	public Horse getHorseexpense() {
		return horseexpense;
	}

	public void setHorseexpense(Horse horseexpense) {
		this.horseexpense = horseexpense;
	}

}
