package es.udc.fic.tfg.account;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "account")
public class Account implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String email;

	private String firstName;

	private String lastName;

	@JsonIgnore
	private String password;

	private String role = "ROLE_USER";

	private String phoneNumber;

	//private bitmap profilePicture;

	private Instant created;

    protected Account() {

	}
	
	public Account(String email, String firstName, String lastName, String password, String role, String phoneNumber) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.created = Instant.now();
	}

	public Long getId() {
		return id;
	}

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPhoneNumber(){ return phoneNumber;}

	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber;}

	/*public bitmap getProfilePicture(){return profilePicture;}

	public void setProfilePicture(bitmap profilePicture){ this.profilePicture = profilePicture;}
	*/
	public Instant getCreated() {
		return created;
	}
}
