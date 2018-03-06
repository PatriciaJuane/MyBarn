package es.udc.fic.tfg.Markings;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "markings")
public class Markings implements Serializable {

    @Id
    @GeneratedValue
    private Long markings_id;

    @Column(unique = true)
    private String name;
    private Instant created;

    public Markings() {
    }

    public Markings(String name) {
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

    public Long getMarkings_id() {
        return markings_id;
    }

}