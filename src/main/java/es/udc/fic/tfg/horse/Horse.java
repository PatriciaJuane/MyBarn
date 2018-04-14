package es.udc.fic.tfg.horse;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;

import javax.persistence.*;
import es.udc.fic.tfg.account.Account;


@SuppressWarnings("serial")
@Entity
@Table(name = "horse")
public class Horse implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long horseId;

	@Column(unique = true)
	private String nickname;

	private String name;

	private String breed;

	private Date birthdate;

	private String gender; //Enumerado

	private String fur; //Enumerado

	private String markings; //Enumerado

	//private bitmap profilePicture;

	private String sire;

	private String damnsire;

   /*
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "horse_account",
			joinColumns = { @JoinColumn(name = "horseId") },
			inverseJoinColumns = { @JoinColumn(name = "accountId") }
	)
	private List<Account> owners;*/

	private String licensenumber;

	private String chipnumber;

	private Instant created;

    protected Horse() {

	}
	
	public Horse(String nickname, String name, String breed, Date birthdate, String gender, String fur,
				 String markings, String sire, String damnsire, List<Account> owners, String licensenumber, String chipnumber) {
		this.nickname = nickname;
		this.name = name;
		this.breed = breed;
		this.birthdate=birthdate;
		this.gender = gender;
		this.fur = fur;
		this.markings = markings;
		this.sire = sire;
		this.damnsire = damnsire;
		//this.owners = owners;
		this.licensenumber = licensenumber;
		this.chipnumber = chipnumber;
		this.created = Instant.now();
	}

	public Long getHorseId() {
		return horseId;
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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthDate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getSire() {
		return sire;
	}

	public void setSire(String sire) {
		this.sire = sire;
	}

	public String getDamnsire() {
		return damnsire;
	}

	public void setDamnsire(String damnSire) {
		this.damnsire = damnSire;
	}

	/*public List<Account> getOwners() {
		return owners;
	} */

	/*public void setOwners(List<Account> owner) {
		this.owners = owners;
	}*/

	public String getLicensenumber() {
		return licensenumber;
	}

	public void setLicensenumber(String licensenumber) {
		this.licensenumber = licensenumber;
	}

	public String getChipnumber() {
		return chipnumber;
	}

	public void setChipnumber(String chipnumber) {
		this.chipnumber = chipnumber;
	}

	/*public bitmap getProfilePicture(){return profilePicture;}

	public void setProfilePicture(bitmap profilePicture){ this.profilePicture = profilePicture;}
	*/
	public Instant getCreated() {
		return created;
	}

	public String getGender() {
		return gender;
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
}
