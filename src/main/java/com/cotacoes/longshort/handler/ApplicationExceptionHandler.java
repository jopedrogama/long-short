package com.cotacoes.longshort.handler;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.cotacoes.longshort.exceptions.ApplicationException;
import com.cotacoes.longshort.exceptions.BadRequestException;
import com.cotacoes.longshort.handler.ErrorMessageResponse.Argument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

        @Autowired
        private MessageSource messageSource;

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                        HttpHeaders headers, HttpStatus status, WebRequest request) {

                List<Argument> invalidArguments = new ArrayList<>();

                ex.getBindingResult().getAllErrors().forEach(error -> {
                        String errorName = ((FieldError) error).getField();
                        String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
                        // String message = error.getDefaultMessage(); PEGA A MENSAGEM PADRAO
                        invalidArguments.add(new ErrorMessageResponse.Argument(errorName, message));
                });

                ErrorMessageResponse errorMessage = new ErrorMessageResponse(status.value(), "Error",
                                OffsetDateTime.now(),
                                invalidArguments);
                return handleExceptionInternal(ex, errorMessage, headers, status, request);
        }

        @ExceptionHandler(BadRequestException.class)
        public ResponseEntity<ApplicationException> handleBadRequestException(BadRequestException badRequest) {
                return new ResponseEntity<>(
                                ApplicationException.builder()
                                                .timestamp(LocalDateTime.now())
                                                .status(HttpStatus.BAD_REQUEST.value())
                                                .title("Bad Request Exception, Verify documentation")
                                                .details(badRequest.getMessage())
                                                .message(badRequest.getClass().getName())
                                                .build(),
                                HttpStatus.BAD_REQUEST);
        }

}
