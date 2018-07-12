package es.udc.fic.tfg.horse;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;

import javax.persistence.*;
import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.activity.Activity;

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

	private String gender; // Enumerado

	private String fur; // Enumerado

	private String markings; // Enumerado

	private String sire;

	private String damnsire;

	@ManyToOne(fetch = FetchType.EAGER)
	// @JoinColumn(name = "owner",insertable = false, updatable = false)
	private Account owner;

	@ManyToOne(fetch = FetchType.EAGER)
	// @JoinColumn(name = "accountid", insertable = false, updatable = false)
	private Account rider; // Para que no tenga jinete inicialmente

	private String licensenumber;

	private String chipnumber;

	private Instant created;

	@Column(length = 10485760)
	private String profilePic = "";

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "activityhorse")
	private List<Activity> horseactivities;

	protected Horse() {

	}

	public Horse(String nickname, String name, String breed, Date birthdate, String gender, String fur, String markings,
			String sire, String damnsire, String licensenumber, String chipnumber, Account owner, Account rider,
			String profilePic, List<Activity> horseactivities) {
		this.nickname = nickname;
		this.name = name;
		this.breed = breed;
		this.birthdate = birthdate;
		this.gender = gender;
		this.fur = fur;
		this.markings = markings;
		this.sire = sire;
		this.damnsire = damnsire;
		this.licensenumber = licensenumber;
		this.chipnumber = chipnumber;
		this.owner = owner;
		this.rider = rider;
		this.created = Instant.now();
		this.profilePic = profilePic;
		this.horseactivities = horseactivities;
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

	public Account getRider() {
		return rider;
	}

	public void setRider(Account rider) {
		this.rider = rider;
	}

	public Account getOwner() {
		return owner;
	}

	public void setOwner(Account owner) {
		this.owner = owner;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public List<Activity> getHorseactivities() { return horseactivities; }

	public void setHorseactivities(List<Activity> horseactivities) { this.horseactivities = horseactivities; }
}
