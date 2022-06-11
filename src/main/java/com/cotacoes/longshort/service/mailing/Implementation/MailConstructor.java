package com.cotacoes.longshort.service.mailing.Implementation;

import com.cotacoes.longshort.model.MailModel;
import com.cotacoes.longshort.service.email.EmailService;
import com.cotacoes.longshort.service.mailing.IMailConstructor;

import java.util.List;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class MailConstructor implements IMailConstructor {

    @Autowired
    EmailService emailService;

    public MimeMessage constuctMime(MailModel mail) {
        MimeMessage mime = new JavaMailSenderImpl().createMimeMessage();
        List<String> listOfemails = emailService.getEmailList();
        Address[] to = new Address[listOfemails.size()];
        for (int i = 0; i < listOfemails.size(); i++) {
            try {
                to[i] = new InternetAddress(listOfemails.get(i));
            } catch (AddressException e) {
                e.printStackTrace();
            }

        }

        try {
            mime.setFrom("jopedrogama@gmail.com");
            mime.addRecipients(Message.RecipientType.TO, to);
            mime.setSubject(mail.getSubject());
            mime.setContent(mail.getBody(), "text/html; charset=utf-8");
        } catch (MessagingException error) {
            System.out.println(error);
        }
        return mime;
    }

}
