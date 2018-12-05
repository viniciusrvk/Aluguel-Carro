package servico;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import modelo.Material;
import modelo.Usuario;


// Strategy
public class Email {
	private String from = "dgeosigufrn@gmail.com";
	private String subject = "@acao de material.";
	private String message = "<h1>DGEOsig</h1>"
			+ "<h2>Confirmação de @acao do material: <strong>@tagMaterial</strong>.</h2>"
			+ "<h3>15 dias para a devolução</3>";
	private String to;
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Email(Usuario user, Material material, String acao) {
		
		this.to = user.get_email();
		subject = subject.replaceAll("@acao", acao);
		message = message.replaceAll("@tagMaterial", material.get_nome());
		message = message.replaceAll("@acao", acao);
	}
	
	public boolean sendEmail() {
		boolean retorno = false;
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		Session s = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(from, "dhv2018.2");
			}
		});
		// Compose msg
		try {
			MimeMessage message = new MimeMessage(s);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.to));
			
			message.setSubject(this.subject);
			message.setContent(this.message, "text/html; charset=utf-8");
			
			// send msg
			Transport.send(message);
			retorno =  true;
		} catch (Exception e) {
			retorno = false;
			e.printStackTrace();
		}
		System.out.println("EMAIL ENVIADO");
		return retorno;
	}
	
}
