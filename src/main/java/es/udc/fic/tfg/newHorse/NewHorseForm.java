package es.udc.fic.tfg.newHorse;

import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.udc.fic.tfg.account.AccountService;
import es.udc.fic.tfg.horse.FurType;
import es.udc.fic.tfg.horse.GenderType;
import es.udc.fic.tfg.horse.MarkingsType;
import org.hibernate.validator.constraints.NotBlank;
import es.udc.fic.tfg.account.AccountRepository;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.horse.Horse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

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

	private String rider;

	@NotBlank(message = NewHorseForm.NOT_BLANK_MESSAGE)
	private String licenseNumber;

	@NotBlank(message = NewHorseForm.NOT_BLANK_MESSAGE)
	private String chipNumber;

    private MultipartFile profilePic;

	private String expenseAmount;

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

	public String getRider() {
		return rider;
	}

	public void setRider(String rider) {
		this.rider = rider;
	}
    public MultipartFile getProfilePic() { return profilePic; }

    public void setProfilePic(MultipartFile profilePic) { this.profilePic = profilePic; }

	public String getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(String expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public Horse createHorse() throws ParseException {
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
	            return new Horse(getNickname(), getName(), getBreed(), getBirthdate(), getGender(), getFur(), getMarkings(),
	    				getSire(),getDamnSire(), getLicenseNumber(),getChipNumber(), getOwner(), null, base64Encoded);
	        } catch (Exception e) {
	            Logger.getGlobal().log(Level.WARNING, e.toString());
	            return null;
	        }
	}

}