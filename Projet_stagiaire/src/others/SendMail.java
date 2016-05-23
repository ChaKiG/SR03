package others;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMail {
	String smtpHost = "smtps.utc.fr";
	String from = "thomas.pelletier@etu.utc.fr";
	String username = "tpelleti";
	String password = "Bqfjyj85";
	Properties props;
	
    public SendMail() {
        props = new Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.auth", "true");	
    }
    
    public void send(String identifiant, String mdp) {
        Session session = Session.getDefaultInstance(props);
        Transport tr = null;
        try {
	        MimeMessage message = new MimeMessage(session);   
	        message.setFrom(new InternetAddress(from));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(identifiant));
	        message.setSubject("Creation de compte !");
	        message.setText("Bonjour,\r\n"
	        		+ "un compte a �t� cr�� pour vous\r\n"
	        		+ "Voici vos identifiants \r\n"
	        		+ " id : " + identifiant + "\r\n"
	        		+ " mdp : " + mdp + "\r\n"
	        		+ "\r\n"
	        		+ "Cordialement");
	        tr = session.getTransport("smtp");
	        tr.connect(smtpHost, username, password);
	        message.saveChanges();
	        tr.sendMessage(message,message.getAllRecipients());
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	try {
        		if (tr != null)
        			tr.close();
        	} catch (Exception e) {}
        }
    }
}