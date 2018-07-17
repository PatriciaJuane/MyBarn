package es.udc.fic.tfg.activity;

import java.time.Instant;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.expense.Expense;
import es.udc.fic.tfg.horse.Horse;

@SuppressWarnings("serial")
@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue
    @Column(name = "activityid")
    private Long activityid;

    private String description;

    private String duration;

    private Date activitydate;

    private String type;

    @ManyToOne(fetch = FetchType.EAGER)
    private Account activityuser;

    @ManyToOne(fetch = FetchType.EAGER)
    private Horse activityhorse;

    @OneToOne(fetch = FetchType.EAGER)
    private Expense activityexpense;

    private Instant created;

    public Long getActivityid() {
        return activityid;
    }

    public void setActivityid(Long activityid) {
        this.activityid = activityid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getActivitydate() {
        return activitydate;
    }

    public void setActivitydate(Date activitydate) {
        this.activitydate = activitydate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Account getActivityuser() {
        return activityuser;
    }

    public void setActivityuser(Account activityuser) {
        this.activityuser = activityuser;
    }

    public Horse getActivityhorse() {
        return activityhorse;
    }

    public void setActivityhorse(Horse activityhorse) {
        this.activityhorse = activityhorse;
    }

    public Expense getActivityexpense() {
        return activityexpense;
    }

    public void setActivityexpense(Expense activityexpense) {
        this.activityexpense = activityexpense;
    }

    public Activity(){

    }

    public Activity(String description, String duration, Date activitydate, String type,
                    Account activityuser, Horse activityhorse, Expense activityexpense){
        this.description = description;
        this.duration = duration;
        this.activitydate = activitydate;
        this.type = type;
        this.activityuser = activityuser;
        this.activityhorse = activityhorse;
        this.activityexpense = activityexpense;
        this.created = Instant.now();
    }
}
