package es.udc.fic.tfg.training;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

public class NewTrainingForm {

    private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";

    @Autowired
    private AccountRepository accountRepository;

    private String description;

    private String duration;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date trainingdate;

    @NotBlank(message = NewTrainingForm.NOT_BLANK_MESSAGE)
    private String type;

    private Account traininguser;

    @NotBlank(message = NewTrainingForm.NOT_BLANK_MESSAGE)
    private String traininghorse;

    private String trainingexpense;

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

    public String getTraininghorse() {
        return traininghorse;
    }

    public void setTraininghorse(String traininghorse) {
        this.traininghorse = traininghorse;
    }

    public String getTrainingexpense() {
        return trainingexpense;
    }

    public void setTrainingexpense(String trainingexpense) {
        this.trainingexpense = trainingexpense;
    }

    public Training createTraining(){
        return new Training(getDescription(),getDuration(), getTrainingdate(), getType(),
                getTraininguser(), null, null);
    }

}
