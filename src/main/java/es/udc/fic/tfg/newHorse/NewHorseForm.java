package es.udc.fic.tfg.newHorse;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.hibernate.validator.constraints.NotBlank;
import es.udc.fic.tfg.account.AccountRepository;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.horse.Horse;

public class NewHorseForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
	private static final String NICKNAME_EXISTS_MESSAGE = "{nickname-exists.message}";

    @NotBlank(message = NewHorseForm.NOT_BLANK_MESSAGE)
	@NicknameExists(message = NewHorseForm.NICKNAME_EXISTS_MESSAGE)
	private String nickname;

    @NotBlank(message = NewHorseForm.NOT_BLANK_MESSAGE)
	private String name;

	@NotBlank(message = NewHorseForm.NOT_BLANK_MESSAGE)
	private String breed;

	@NotBlank(message = NewHorseForm.NOT_BLANK_MESSAGE)
	private String birthDate;

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

	//private Account owner;

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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
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

	/*OBTENERLO DE PRINCIPAL!!!!*/
	/*public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

	/*Habría que añadir el owner*/
	public Horse createHorse() throws ParseException {
		String string = getBirthDate();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		Date date = format.parse(string);

        return new Horse(getNickname(), getName(), getBreed(), date, getGender(),getFur(),getMarkings(),
				getSire(),getDamnSire(),getLicenseNumber(),getChipNumber());
	}
}
