package com.cotacoes.longshort.dto.Email;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class RecieverEmailDTO {

    @NotEmpty(message = "Email field can not be empty")
    @Email
    private String email;

}
