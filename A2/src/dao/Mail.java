package dao;

import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mysql.cj.PreparedQuery;
import com.sun.istack.internal.logging.Logger;

public class Mail implements Observer {

	@Override
	public void sendMail(String recepient)
	{
	  Properties properties = System.getProperties();
      
	  properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable", "true");
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.port", "587"); 
      
      //String to = "biancadondas21@gmail.com";
      String from = "biancadondas21@gmail.com";
      //String host = "127.0.0.1";            
      String password = "Parola";
      
      Session sesion = Session.getInstance(properties, new Authenticator() {
    	  @Override
    	  protected PasswordAuthentication getPasswordAuthentication()
    	  {
    		  return new PasswordAuthentication(from, password);
    	  }
	});
      
      Message message = prepareMessage(sesion, from, recepient);
      try {
		Transport.send(message);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public static Message prepareMessage(Session session, String from, String recepient) {
		
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("Book Available");
			message.setText("Hello! Your book is now available and it has been asignated to you in our app!");
			return message;
		} catch (Exception e) {
			Logger.getLogger(Mail.class.getName(), null).log(Level.SEVERE,null,e);
		}
		return null;
		
	}
	
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		 //System.out.println("merge?");
//		 UserDAO u = new UserDAO();
//		 //u.showAllUsers();
//		 //u.insertUser("Test11","doi" , "trei","patru");
//		 //System.out.println(u.searchUser("test", "test"));
//		 
//		       // mail server host
//	       Properties properties = System.getProperties();
////	        properties.setProperty("mail.smtp.host", host);
////
////	        Session session = Session.getDefaultInstance(properties); // default session
////
////	        try {
////	            MimeMessage message = new MimeMessage(session);        // email message
////	            message.setFrom(new InternetAddress(from));                    // setting header fields
////	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
////	            message.setSubject("Test Mail from Java Program"); // subject line
////
////	            // actual mail body
////	            message.setText("You can send mail from Java program by using mail API, but you need"
////	                    + "couple of more JAR files e.g. smtp.jar and activation.jar");
////
////	            // Send message
////	            Transport.send(message);
////	            System.out.println("Email Sent successfully....");
////	        } catch (MessagingException mex) {
////	            mex.printStackTrace();
////	        }
////	    }
//	      properties.put("mail.smtp.auth", "true");
//	      properties.put("mail.smtp.starttls.enable", "true");
//	      properties.put("mail.smtp.host", "smtp.gmail.com");
//	      properties.put("mail.smtp.port", "587"); 
//	      String to = "biancadondas21@gmail.com";
//	      String from = "biancadondas21@gmail.com";
//	      //String host = "127.0.0.1";            
//	      String password = "Bleckyblanca12";
//	      Session sesion = Session.getInstance(properties, new Authenticator() {
//	    	  @Override
//	    	  protected PasswordAuthentication getPasswordAuthentication()
//	    	  {
//	    		  return new PasswordAuthentication(from, password);
//	    	  }
//		});
////	      
////	      
//	     
//	   
//		 
//		 
//		 
//}
}
