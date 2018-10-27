package com.yaruis.ecommercebackend.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

@Service
public class Email {

	public void send(UserCustomer user, String subject, String body) throws MessagingException, IOException {

		final String username = "yaruisshopanywhere@gmail.com";
		final String password = "yaruis1996";
		// Set Mail Properties
		Properties props = System.getProperties();
		String host_name = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host_name);
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		MimeMessage message = new MimeMessage(session);

		try {
			// set email data
			message.setFrom(new InternetAddress("YashJariwala"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getUseremail()));
			message.setSubject(subject);
			MimeMultipart multipart = new MimeMultipart("related");
			BodyPart messageBodyPart = new MimeBodyPart();
			// messageBodyPart.setContent(body);

			// Set Key Values
			Map<String, String> input = new HashMap<String, String>();
			input.put("Author", "Yash Jariwala - Yaruis");
			input.put("Topic", "Email");
			input.put("Content In", "English");
			// second part (the image)
			// HTML Mail Content
			messageBodyPart.setContent(body, "text/html");
			multipart.addBodyPart(messageBodyPart);
			
			
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource("C:\\Users\\yashj\\Eclipse Workspace\\YaruisFrontEnd\\src\\main\\webapp\\resources\\images\\card.png");
			System.out.println("Image found");
			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);

			// connect to Smtp sever and send email
			Transport transport = session.getTransport("smtp");
			transport.connect(host_name, username, password);
			transport.send(message, message.getAllRecipients());
			transport.close();
			System.out.println("Mail Sent Sucessfully......");
		} catch (MessagingException e) {
			Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, e);
		} catch (Exception ae) {
			ae.printStackTrace();
		}

	}
}