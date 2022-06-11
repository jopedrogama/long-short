package com.cotacoes.longshort.controller;

import java.util.List;

import javax.validation.Valid;

import com.cotacoes.longshort.dto.Email.EmailMapper;
import com.cotacoes.longshort.dto.Email.RecieverEmailDTO;
import com.cotacoes.longshort.model.RecieverEmailModel;
import com.cotacoes.longshort.service.email.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @Autowired
    EmailMapper emailMapper;

    @GetMapping()
    public List<RecieverEmailModel> getEmails() {
        return emailService.getAll();
    }

    @PostMapping
    public RecieverEmailModel registerEmail(@Valid @RequestBody RecieverEmailDTO email) {
        RecieverEmailModel recieverEmail = emailMapper.toModel(email);
        emailService.insert(recieverEmail);
        return recieverEmail;
    }

    @PostMapping("/file")
    public List<RecieverEmailModel> registerEmailThroughFile(@RequestParam() MultipartFile file) {
        return emailService.insertThroughFile(file);
    }

    @DeleteMapping
    public List<RecieverEmailModel> delete(@Valid @RequestBody RecieverEmailDTO email) {
        RecieverEmailModel recieverEmail = emailMapper.toModel(email);
        return emailService.delete(recieverEmail);
    }
}
