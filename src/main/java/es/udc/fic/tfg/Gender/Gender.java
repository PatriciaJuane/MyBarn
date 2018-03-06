package es.udc.fic.tfg.Gender;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@SuppressWarnings("serial")
@Entity
@Table(name = "gender")
public class Gender implements Serializable {

    @Id
    @GeneratedValue
    private Long gender_id;

    @Column(unique = true)
    private String name;
    private Instant created;

    public Gender() {
    }

    public Gender(String name) {
        this.name = name;
        this.created = Instant.now();
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGender_id() {
        return gender_id;
    }

}