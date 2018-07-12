package es.udc.fic.tfg.activity;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class NewActivityForm {

    private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";

    @Autowired
    private AccountRepository accountRepository;

    private String description;

    private String duration;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date activitydate;

    @NotBlank(message = NewActivityForm.NOT_BLANK_MESSAGE)
    private String type;

    private Account activityuser;

    @NotBlank(message = NewActivityForm.NOT_BLANK_MESSAGE)
    private String activityhorse;

    private String activityexpense;

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

    public String getActivityhorse() {
        return activityhorse;
    }

    public void setActivityhorse(String activityhorse) {
        this.activityhorse = activityhorse;
    }

    public String getActivityexpense() {
        return activityexpense;
    }

    public void setActivityexpense(String activityexpense) {
        this.activityexpense = activityexpense;
    }

    public Activity createActivity() {
        return new Activity(getDescription(),getDuration(), getActivitydate(), getType(),
                    getActivityuser(),null,null);
    }

}
