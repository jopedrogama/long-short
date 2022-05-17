package com.cotacoes.longshort.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document()
public class Email {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;
    private String email;
    private boolean active = true;

}
