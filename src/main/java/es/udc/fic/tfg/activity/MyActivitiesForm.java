package es.udc.fic.tfg.activity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MyActivitiesForm {

    private String horsename;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date activitydate;


    public String getHorsename() { return horsename; }

    public void setHorsename(String horsename) {
        this.horsename = horsename;
    }


    public Date getActivitydate() {
        return activitydate;
    }

    public void setActivitydate(Date activitydate) {
        this.activitydate = activitydate;
    }

}
