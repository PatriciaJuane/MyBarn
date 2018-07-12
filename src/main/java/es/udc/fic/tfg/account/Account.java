package es.udc.fic.tfg.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import es.udc.fic.tfg.activity.Activity;
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
    @Column(name="accountid")
    private Long accountid;

    @Column(unique = true)
    private String email;

    private String firstname;

    private String lastname;

    @JsonIgnore
    private String password;

    private String role = "ROLE_USER";

    private String phonenumber;

    private Boolean rider; //Por si el usuario, ademas de propietario, decide ser jinete

   // private Boolean owner;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    private List<Horse> horsesOwned;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "rider")
    private List<Horse> horsesRidden;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "activityuser")
    private List<Activity> useractivities;

    @Column(length=10485760)
    private String profilePic = "";

    private Instant created;

    public Account() {

    }

    public Account(String email, String firstname, String lastname, String password,
                   String role, String phonenumber, Boolean rider, List<Horse> horsesOwned,
                   List<Horse> horsesRidden, String profilePic, List<Activity> useractivities) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.role = role;
        this.phonenumber = phonenumber;
        this.rider = rider;
        this.horsesOwned = new ArrayList<>();
        this.horsesRidden = new ArrayList<>();
        this.created = Instant.now();
        this.profilePic = profilePic;
        this.useractivities = new ArrayList<>();
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

    public Boolean getRider() { return rider; }

    public void setRider(Boolean rider) { this.rider = rider; }

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

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public List<Activity> getUseractivities() { return useractivities; }

    public void setUseractivities(List<Activity> useractivities) { this.useractivities = useractivities; }
}