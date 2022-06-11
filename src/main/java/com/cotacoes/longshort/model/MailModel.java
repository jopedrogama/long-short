package com.cotacoes.longshort.model;

import java.util.List;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class MailModel {
    private String sender;
    private String body;
    private List<String> reciever;
    private String subject;

    public boolean isFilled() {
        if ((body.isEmpty() || body.isBlank()) || (subject.isBlank() || subject.isEmpty())) {
            return false;

        }
        return true;
    }

}
