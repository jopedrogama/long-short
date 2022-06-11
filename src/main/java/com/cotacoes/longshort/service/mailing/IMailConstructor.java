package com.cotacoes.longshort.service.mailing;

import com.cotacoes.longshort.model.MailModel;

import javax.mail.internet.MimeMessage;

public interface IMailConstructor {

    public MimeMessage constuctMime(MailModel mail);

}
