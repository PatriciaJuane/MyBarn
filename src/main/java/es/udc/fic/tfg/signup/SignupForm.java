package es.udc.fic.tfg.signup;

import es.udc.fic.tfg.horse.Horse;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import es.udc.fic.tfg.account.Account;
import org.springframework.web.multipart.MultipartFile;
import javassist.bytecode.ByteArray;
import org.hibernate.validator.constraints.*;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    private MultipartFile profilePic;

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

    public MultipartFile getProfilePic() { return profilePic; }

    public void setProfilePic(MultipartFile profilePic) { this.profilePic = profilePic; }


    public Account createAccount() {

        try {
            byte[] bytes = null;
            String base64Encoded = null;
            if (getProfilePic() != null) {
                try {
                    bytes = getProfilePic().getBytes();
                    base64Encoded = Base64.getEncoder().encodeToString(bytes);
                } catch (IOException e) {
                    Logger.getGlobal().log(Level.WARNING, e.toString());
                }
            }
            return new Account(getEmail(), getFirstname(), getLastname(), getPassword(), "ROLE_USER", getPhonenumber(),
                    getRider(), getHorsesOwned(), getHorsesRidden(), base64Encoded);
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, e.toString());
            return null;
        }
    }

   /* public Account createAccount() {

        return new Account(getEmail(), getFirstname(), getLastname(), getPassword(), "ROLE_USER", getPhonenumber(),
                getRider(), getHorsesOwned(), getHorsesRidden());
    } */
}
