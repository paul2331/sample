package org.arpit.java2blog.util;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;  
import javax.activation.*;  

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Qualifier("gmailClient")
@Component
public class GMailClient {
	private static final String from = "chennaiauditmailservice@gmail.com";
	private static final String password = "siva1raj";
	public static Session getSession() {
		//Get properties object    
        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(from,password);  
         }    
        });  
        return session;
	}
	public static void read() {
		Session session2 = getSession();
		 try {			 
             Store store=session2.getStore("imaps");
             store.connect("smtp.gmail.com",from, password);
             Folder folder=store.getFolder("INBOX");//get inbox
             folder.open(Folder.READ_ONLY);//open folder only to read
             Message message[]=folder.getMessages();
             System.out.println("------->"+message.length);
             for(int i=0;i<message.length;i++){
                 System.out.println("Subject--->"+message[i].getSubject());
                 System.out.println("content---->"+message[i].getContent().toString());
             }
             //close connections
             folder.close(true);
             store.close();

     } catch (Exception e) {
             System.out.println(e.toString());
     }

	}
	public static void sendWithAttachment(String to,String sub,String msg,String filename) {
		Session session = getSession(); 
		//2) compose message     
		try{  
		    MimeMessage message = new MimeMessage(session);  
		    message.setFrom(new InternetAddress(from));  
		    String arr[] = to.split(";");
	         Address address[] = new Address[arr.length];
	         for(int i=0;i<arr.length;i++) {
	        	 address[i] = new InternetAddress(arr[i]);
	         }
	         if(arr.length>1) {
	        	 message.addRecipients(Message.RecipientType.BCC, address);
	         }else {
	        	 message.addRecipients(Message.RecipientType.TO, address);
	         }
		    message.setSubject(sub);  
		      
		    //3) create MimeBodyPart object and set your message text     
		    BodyPart messageBodyPart1 = new MimeBodyPart();  
		    messageBodyPart1.setText(msg);  
		      
		    //4) create new MimeBodyPart object and set DataHandler object to this object      
		    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
		  		    
		    DataSource source = new FileDataSource(filename);  
		    messageBodyPart2.setDataHandler(new DataHandler(source));  
		    messageBodyPart2.setFileName(filename);  		     
		     
		    //5) create Multipart object and add MimeBodyPart objects to this object      
		    Multipart multipart = new MimeMultipart();  
		    multipart.addBodyPart(messageBodyPart1);  
		    multipart.addBodyPart(messageBodyPart2);  
		  
		    //6) set the multiplart object to the message object  
		    message.setContent(multipart );  
		     
		    //7) send message  
		    Transport.send(message);  
		   
		   System.out.println("message sent....");  
		 }catch (MessagingException ex) {ex.printStackTrace();}  		 
	}
	public static void send(String to,String sub,String msg){  
		Session session = getSession();  
        //compose message    
        try {    
	         MimeMessage message = new MimeMessage(session);   
	         String arr[] = to.split(";");
	         Address address[] = new Address[arr.length];
	         for(int i=0;i<arr.length;i++) {
	        	 address[i] = new InternetAddress(arr[i]);
	         }
	         if(arr.length>1) {
	        	 message.addRecipients(Message.RecipientType.BCC, address);
	         }else {
	        	 message.addRecipients(Message.RecipientType.TO, address);
	         }
	         //message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
	         message.setSubject(sub);    
	         message.setText(msg);    
	         //send message  
	         Transport.send(message);    
	         System.out.println("message sent successfully");    
        } catch (MessagingException e) {throw new RuntimeException(e);}    
           
     }
	 public static void main(String[] args) {    
	     //from,password,to,subject,message  
		 String filename = "C:\\Users\\Kirtheesh\\Desktop\\11.jpg";
		 GMailClient.sendWithAttachment("paulraj86@gmail.com","test mail with attach","this is kirtheesh pp", filename);
		 //GMailClient.read();
		 //GMailClient.send("paulraj86@gmail.com;paulraj86@yahoo.co.in","hello javatpoint","How r u?");  
	     //change from, password and to  
	 }    
}

