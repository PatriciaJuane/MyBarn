package es.udc.fic.tfg.signup;

import es.udc.fic.tfg.horse.Horse;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import es.udc.fic.tfg.account.Account;

import java.util.ArrayList;
import java.util.List;

public class SignupForm {

    private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
    private static final String EMAIL_MESSAGE = "{email.message}";
    private static final String EMAIL_EXISTS_MESSAGE = "{email-exists.message}";

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    //@Email(message = SignupForm.EMAIL_MESSAGE)
    //@EmailExists(message = SignupForm.EMAIL_EXISTS_MESSAGE)
    private String email;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    private String password;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    private String firstname;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    private String lastname;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    private String phonenumber;

    private Boolean rider;

    private List<Horse> horsesOwned;

    private List<Horse> horsesRidden;
    //= new ArrayList<Horse>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Boolean getRider() { return rider; }

    public void setRider(Boolean rider) { this.rider = rider; }

    public List<Horse> getHorsesOwned() { return horsesOwned; }

    public void setHorsesOwned(List<Horse> horsesOwned) { this.horsesOwned = horsesOwned; }

    public List<Horse> getHorsesRidden() { return horsesRidden; }

    public void setHorsesRidden(List<Horse> horsesRidden) { this.horsesRidden = horsesRidden; }

    public Account createAccount() {
        return new Account(getEmail(), getFirstname(), getLastname(), getPassword(), "ROLE_USER", getPhonenumber(),
                getRider(), getHorsesOwned(), getHorsesRidden());
    }
}
