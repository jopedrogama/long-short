package com.cotacoes.longshort.model;

import javax.validation.constraints.Email;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document()
public class RecieverEmailModel {

    @Id
    private String id;
    private String name;

    @Indexed(unique = true)
    @Email
    private String email;
    private boolean active = true;

}
