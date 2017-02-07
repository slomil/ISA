package restaurant.domain;

import java.security.Security;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.validation.Valid;

public class Email {

	public Email(){
		
	}
	
	public void sendEmail(final String kime,final String lozinka){
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getInstance(props,new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("slomil571@gmail.com", "slobodan1993");
				}
			});
		
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("slomil571@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(kime));
			message.setSubject("Registration Completed");
			
			MimeBodyPart mbp=new MimeBodyPart();
			String body="Thank you for registration!"
					+ "<br><br> In order to activate your account,please confirm registration"
					+ " at the following link <a href=\"http://localhost:8080/registracija/success\">http://localhost:8080/registracija/success</a>.<br>"
					+ "Your credentials are:<br>Username:"+String.valueOf(kime)+"<br>"
					+ "Password:"+lozinka;
			mbp.setText(body, "UTF-8", "html");
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mbp);
			message.setContent(multipart);
			
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
}
