package es.udc.fic.tfg.horse;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.*;
import es.udc.fic.tfg.account.Account;

@SuppressWarnings("serial")
@Entity
@Table(name = "horse")
public class Horse implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String nickname;

	private String name;

	private String breed;

	private Date birthDate;

	private String gender; //Enumerado

	private String fur; //Enumerado

	private String markings; //Enumerado

/*	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "fur_id")
	private Fur fur;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "gender_id")
	private Gender gender;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "markings_id")
	private Markings markings;
	*/

	//private bitmap profilePicture;

	private String sire;

	private String damnSire;

	/*@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "account_id") //name = "id" ???
	private Account owner;
	*/
	private String licenseNumber;

	private String chipNumber;

	private Instant created;

    protected Horse() {

	}
	
	public Horse(String nickname, String name, String breed, Date birthDate, String gender, String fur,
				 String markings, String sire, String damnSire, String licenseNumber, String chipNumber) {
		this.nickname = nickname;
		this.name = name;
		this.breed = breed;
		this.birthDate=birthDate;
		this.gender = gender;
		this.fur = fur;
		this.markings = markings;
		this.sire = sire;
		this.damnSire = damnSire;
		//this.owner = owner;
		this.licenseNumber = licenseNumber;
		this.chipNumber = chipNumber;
		this.created = Instant.now();
	}

	public Long getId() {
		return id;
	}

    public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFur() {
		return fur;
	}

	public void setFur(String fur) {
		this.fur = fur;
	}

	public String getMarkings() {
		return markings;
	}

	public void setMarkings(String markings) {
		this.markings = markings;
	}

	public String getSire() {
		return sire;
	}

	public void setSire(String sire) {
		this.sire = sire;
	}

	public String getDamnSire() {
		return damnSire;
	}

	public void setDamnSire(String damnSire) {
		this.damnSire = damnSire;
	}

	/*public Account getOwner() {
		return owner;
	}

	public void setOwner(Account owner) {
		this.owner = owner;
	}*/

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getChipNumber() {
		return chipNumber;
	}

	public void setChipNumber(String chipNumber) {
		this.chipNumber = chipNumber;
	}

	/*public bitmap getProfilePicture(){return profilePicture;}

	public void setProfilePicture(bitmap profilePicture){ this.profilePicture = profilePicture;}
	*/
	public Instant getCreated() {
		return created;
	}
}
