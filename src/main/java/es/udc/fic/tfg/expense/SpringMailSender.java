package es.udc.fic.tfg.expense;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SpringMailSender {

    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.setProperty("mail.smtp.auth", "true");;
        return properties;
    }

    @Transactional
    public void sendMail(String fromEmail,String toEmail,String emailSubject, String body) {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        SimpleMailMessage emailTemplate = new SimpleMailMessage();
        javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setJavaMailProperties(getMailProperties());
        javaMailSender.setUsername("patriciatfg1@gmail.com");
        javaMailSender.setPassword("patriciatfg1111");
        emailTemplate.setTo(toEmail);
        emailTemplate.setFrom("patriciatfg1@gmail.com");
        emailTemplate.setSubject(emailSubject);
        emailTemplate.setText(body);
        javaMailSender.send(emailTemplate);

    }

}

