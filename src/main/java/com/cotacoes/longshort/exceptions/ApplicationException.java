package com.cotacoes.longshort.exceptions;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ApplicationException {

    private String title;
    private int status;
    private String details;
    private String message;
    private LocalDateTime timestamp;

}
