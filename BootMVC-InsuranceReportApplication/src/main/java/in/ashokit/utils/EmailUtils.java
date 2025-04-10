package in.ashokit.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender mailSender;
	public boolean send(String sub,String body,String to,File f) {
		try {
			MimeMessage mime=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mime,true);
			helper.setSubject(sub);
			helper.addAttachment("plans-Info", f);
			helper.setText(body, true);
			helper.setTo(to);
			
			mailSender.send(mime);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
