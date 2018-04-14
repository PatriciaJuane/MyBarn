package es.udc.fic.tfg.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import es.udc.fic.tfg.horse.Horse;

import javax.persistence.*;
import java.time.Instant;
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

	private String firstName;

	private String lastName;

	@JsonIgnore
	private String password;

	private String role = "ROLE_USER";

	private String phoneNumber;

	//@ManyToMany(fetch = FetchType.LAZY, mappedBy = "owners")
	//private List<Horse> horses;

	//private bitmap profilePicture;

	private Instant created;

    protected Account() {

	}
	
	public Account(String email, String firstName, String lastName, String password, String role, String phoneNumber, List<Horse> horses) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
		this.phoneNumber = phoneNumber;
		//this.horses = horses;
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

	/*public List<Horse> getHorses() {
		return horses;
	}

	public void setHorses(List<Horse> horses) {
		this.horses = horses;
	}*/

	/*public bitmap getProfilePicture(){return profilePicture;}

	public void setProfilePicture(bitmap profilePicture){ this.profilePicture = profilePicture;}
	*/
	public Instant getCreated() {
		return created;
	}
}
