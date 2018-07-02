package es.udc.fic.tfg.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import es.udc.fic.tfg.horse.Horse;


import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "account")
public class Account implements java.io.Serializable {

    @Id
    @GeneratedValue
    private Long accountid;

    @Column(unique = true)
    private String email;

    private String firstname;

    private String lastname;

    @JsonIgnore
    private String password;

    private String role = "ROLE_USER";

    private String phonenumber;
    

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    private List<Horse> horsesOwned = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "rider")
    private List<Horse> horsesRidden = new ArrayList<>();


    //private bitmap profilePicture;

    private Instant created;

    public Account() {

    }

    public Account(String email, String firstname, String lastname, String password, String role, String phonenumber, List<Horse> horses) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.role = role;
        this.phonenumber = phonenumber;
        this.horsesOwned = new ArrayList<>();
        this.horsesRidden = new ArrayList<>();
        this.created = Instant.now();
    }

    public Long getAccountId() {
        return accountid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    /*public bitmap getProfilePicture(){return profilePicture;}

    public void setProfilePicture(bitmap profilePicture){ this.profilePicture = profilePicture;}
    */
    public Instant getCreated() {
        return created;
    }

    public List<Horse> getHorsesOwned() {
        return horsesOwned;
    }

    public void setHorsesOwned(List<Horse> horsesOwned) {
        this.horsesOwned = horsesOwned;
    }

    public List<Horse> getHorsesRidden() {
        return horsesRidden;
    }

    public void setHorsesRidden(List<Horse> horsesRidden) {
        this.horsesRidden = horsesRidden;
    }
}
