package es.udc.fic.tfg.training;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.expense.Expense;
import es.udc.fic.tfg.horse.Horse;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue
    @Column(name = "trainingid")
    private Long trainingid;

    private String description;

    private String duration;

    private Date trainingdate;

    private String type;

    @ManyToOne(fetch = FetchType.EAGER)
    private Account traininguser;

    @ManyToOne(fetch = FetchType.EAGER)
    private Horse traininghorse;

    @OneToOne(fetch = FetchType.EAGER)
    private Expense trainingexpense;

    private Instant created;

    public Long getTrainingid() {
        return trainingid;
    }

    public void setTrainingid(Long trainingid) {
        this.trainingid = trainingid;
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

    public Date getTrainingdate() {
        return trainingdate;
    }

    public void setTrainingdate(Date trainingdate) {
        this.trainingdate = trainingdate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Account getTraininguser() {
        return traininguser;
    }

    public void setTraininguser(Account traininguser) {
        this.traininguser = traininguser;
    }

    public Horse getTraininghorse() {
        return traininghorse;
    }

    public void setTraininghorse(Horse traininghorse) {
        this.traininghorse = traininghorse;
    }

    public Expense getTrainingexpense() {
        return trainingexpense;
    }

    public void setTrainingexpense(Expense trainingexpense) {
        this.trainingexpense = trainingexpense;
    }

    public Training(){

    }

    public Training(String description, String duration, Date trainingdate, String type,
                    Account traininguser, Horse traininghorse, Expense trainingexpense){

        this.description = description;
        this.duration = duration;
        this.trainingdate = trainingdate;
        this.type = type;
        this.traininguser = traininguser;
        this.traininghorse = traininghorse;
        this.trainingexpense = trainingexpense;
        this.created = Instant.now();
    }

}
