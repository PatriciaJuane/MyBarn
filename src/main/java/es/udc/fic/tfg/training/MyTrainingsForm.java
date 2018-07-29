package es.udc.fic.tfg.training;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MyTrainingsForm {

    private String horsename;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date trainingdate;

    public String getHorsename() { return horsename; }

    public void setHorsename(String horsename) {
        this.horsename = horsename;
    }

    public Date getTrainingdate() {
        return trainingdate;
    }

    public void setTrainingdate(Date trainingdate) {
        this.trainingdate = trainingdate;
    }
}
