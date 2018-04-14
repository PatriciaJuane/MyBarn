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
	@Email(message = SignupForm.EMAIL_MESSAGE)
	@EmailExists(message = SignupForm.EMAIL_EXISTS_MESSAGE)
	private String email;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	private String password;

	@NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	private String firstName;

	@NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	private String lastName;

	@NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
	private String phoneNumber;

	private List<Horse> horses = new ArrayList<Horse>();


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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Horse> getHorses() {
		return horses;
	}

	public void setHorses(List<Horse> horses) {
		this.horses = horses;
	}

	public Account createAccount() {
        return new Account(getEmail(), getFirstName(), getLastName(), getPassword(), "ROLE_USER", getPhoneNumber(), getHorses());
	}
}
