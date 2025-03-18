package Common;

import java.time.Instant;
import java.util.Properties;

import javax.activation.DataHandler;
//import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
//import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
//import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

import com.extentReports.ExtentManager;
import com.sun.mail.smtp.SMTPSendFailedException;

import Utility.ReadProperty;
import Utility.TimeFinder;

public class TriggerEmail extends ExtentManager {

	public static ReadProperty readproperty = new ReadProperty();
	public static String emaillist = "neha.kottawar@speridian.com";
	public static String from = "donotreply@benefitalign.com";
	public static String ReportFileName =			
	".\\TestReport\\CE_Marketing_Leads_Quotes_Policies_Carrier_Automation_Report_" + formatter.format(date) + ".html";
	
	public static void sendReport() throws Exception, SMTPSendFailedException {
		// Create object of Property file
		Properties props = new Properties();
		// this will set host of server- you can change based on your requirement
		props.put("mail.smtp.host", "mail.authsmtp.com");
		// set the port of SMTP server
		props.put("mail.smtp.port", "587");
		// set the authentication to true
		props.put("mail.smtp.auth", "true");
		// props.put("mail.smtp.starttls.enable", "true");
		// props.put("mail.smtp.starttls.required", "true");
		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication("ac65153", "snzjgjn5spmgha");
			}
		});
		try {
			// Create object of MimeMessage class
			MimeMessage message = new MimeMessage(session);

			// Set the from address
			message.setFrom(new InternetAddress(from));

			// Set the recipient address .getRecipients(RecipientType.TO);
			message.addRecipients(RecipientType.TO, InternetAddress.parse(readproperty.loadProperty("emailTo")));
			message.addRecipients(RecipientType.CC, InternetAddress.parse(readproperty.loadProperty("emailCC1")));
			// message.addRecipients(Message.RecipientType.CC,
			// InternetAddress.parse(readproperty.loadProperty("emailCC1")));
			// Add the subject link
			message.setSubject("CE Automation Regression Reports" + "_" + TimeFinder.currentSystemTime());

			// Create object to add multimedia type content
			BodyPart heading = new MimeBodyPart();
			BodyPart salutation = new MimeBodyPart();

			// Set the body of email
			heading.setText("CE Automation Regression Reports => " + TimeFinder.currentSystemTime());
			salutation.setText("~Team Automation QA");

			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// Mention the file which you want to send
		//	String filename = Main.ReportFileName;
			String filename = ReportFileName;


			// Create data source and pass the filename
			FileDataSource source = new FileDataSource(filename);

			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));

			// set the file
			messageBodyPart2.setFileName(filename);

			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();

			// add body part 1
			multipart.addBodyPart(messageBodyPart2);

			// add body part 2
			multipart.addBodyPart(heading);
			multipart.addBodyPart(salutation);

			// set the content
			message.setContent(multipart);

			// finally send the email
			Transport.send(message);

			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}
}
