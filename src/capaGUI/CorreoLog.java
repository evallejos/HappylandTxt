/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capaGUI;

import java.util.Properties;
import javax.mail.Message;  
import javax.mail.MessagingException;  
import javax.mail.PasswordAuthentication;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage; 

public class CorreoLog {
    
    
    
   Properties props = new Properties();
	
	

	private void envioCorreo() {
		  
        props.put("mail.smtp.host", "10.100.50.100"); 
    
      Session session = Session.getDefaultInstance(props);
      session.setDebug(true);     
      
      MimeMessage message = new MimeMessage(session);

       

        try {
            
            // Quien envia el correo
            message.setFrom(new InternetAddress("log@itahue.com"));

             // A quien va dirigido
             message.addRecipient(Message.RecipientType.TO, new InternetAddress("evallejos@itahue.com"));
             
             message.setSubject("Hola");
             message.setText("Mensajito con Java Mail" + "de los buenos." +"poque si");
             
             Transport t = session.getTransport("smtp");
             
             t.sendMessage(message,message.getAllRecipients());

        } catch (Exception e) {
            // ...
               
        }
        
    
        }
        
        
}
