package com.cotacoes.longshort.service.mailing.Implementation;

import com.cotacoes.longshort.model.MailModel;
import com.cotacoes.longshort.service.mailing.IMailService;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class SendGridService implements IMailService {

    @Autowired
    JavaMailSender emailSender;

    @Autowired
    MailConstructor mailConstructor;

    @Override
    public void send(MailModel mail) {
        try {
            MimeMessage message = mailConstructor.constuctMime(mail);
            emailSender.send(message);

        } catch (MailException ex) {
            System.out.println(ex);
        }
    }

}
