package es.udc.fic.tfg.userDetails;

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

public class ProfilePicForm {

	private MultipartFile profilePic; 

    public MultipartFile getProfilePic() { return profilePic; }

    public void setProfilePic(MultipartFile profilePic) { this.profilePic = profilePic; }


    public String changePhoto(Account a) {

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
            return base64Encoded;
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, e.toString());
            return null;
        }
    }
 
}
