//https://stackoverflow.com/users/1288/bill-the-lizard
package Email;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Email {
	
	static ArrayList<String> id = new ArrayList<String>();	
	
    private static String USER_NAME = "ghost2092000";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "Modesto209"; // GMail password
    private static String RECIPIENT = "ghost2092000@yahoo.com";

    
    
    public Email(ArrayList<String> array1) {
    	
    	System.out.println("This is the array on email: "+array1);
    	
    	for (int x = 0;  x < array1.size(); x++) {
    		id.add(array1.get(x));
    	}
    	System.out.println("Worked "+id);	
    	run();
    	
    }

	public static void main(String[] args) {
       run();
    }

	
	
	public static void run(){
		 String from = USER_NAME;
	        String pass = PASSWORD;
	        String[] to = { RECIPIENT }; // list of recipient email addresses
	        String subject = "Follow up with Leads ";
	        String body = "The Leads to follow up with have ID: " + id;

	        sendFromGMail(from, pass, to, subject, body);
			
	        System.out.println("The new Lead to follow up with ID" + id);

	}

    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            
            System.out.println("SENT");

        }
        
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}