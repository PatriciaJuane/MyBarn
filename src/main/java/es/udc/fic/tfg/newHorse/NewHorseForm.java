package es.udc.fic.tfg.newHorse;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import es.udc.fic.tfg.horse.FurType;
import es.udc.fic.tfg.horse.GenderType;
import es.udc.fic.tfg.horse.MarkingsType;
import org.hibernate.validator.constraints.NotBlank;
import es.udc.fic.tfg.account.AccountRepository;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.horse.Horse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

public class NewHorseForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
	private static final String NICKNAME_EXISTS_MESSAGE = "{nickname-exists.message}";

	@Autowired
	private AccountRepository accountRepository;


	@NotBlank(message = NewHorseForm.NOT_BLANK_MESSAGE)
	//@NicknameExists(message = NewHorseForm.NICKNAME_EXISTS_MESSAGE)
	private String nickname;

    @NotBlank(message = NewHorseForm.NOT_BLANK_MESSAGE)
	private String name;

	@NotBlank(message = NewHorseForm.NOT_BLANK_MESSAGE)
	private String breed;

	//@NotNull(message = NewHorseForm.NOT_BLANK_MESSAGE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthdate;

	@NotBlank(message = NewHorseForm.NOT_BLANK_MESSAGE)
	private String gender;

	@NotBlank(message = NewHorseForm.NOT_BLANK_MESSAGE)
	private String fur;

	@NotBlank(message = NewHorseForm.NOT_BLANK_MESSAGE)
	private String markings;

	@NotBlank(message = NewHorseForm.NOT_BLANK_MESSAGE)
	private String sire;

	@NotBlank(message = NewHorseForm.NOT_BLANK_MESSAGE)
	private String damnSire;

	private Account owner;

	private Account rider;

	@NotBlank(message = NewHorseForm.NOT_BLANK_MESSAGE)
	private String licenseNumber;

	@NotBlank(message = NewHorseForm.NOT_BLANK_MESSAGE)
	private String chipNumber;


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

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
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

	public Account getOwner() {
		return owner;
	}

	public void setOwner(Account owner) {
		this.owner = owner;
	}

	public Account getRider() {
		return rider;
	}

	public void setRider(Account rider) {
		this.rider = rider;
	}

	public Horse createHorse() throws ParseException {

		//Recibes de la vista el email o nombre del rider
		//Hacer aquí la búsqueda (findByEmail) y obtener el Account Rider
		//y mandárselo al constructor

		return new Horse(getNickname(), getName(), getBreed(), getBirthdate(), getGender(), getFur(), getMarkings(),
				getSire(),getDamnSire(), getLicenseNumber(),getChipNumber(), getOwner(), null);
	}


}
