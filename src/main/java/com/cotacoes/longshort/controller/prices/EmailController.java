package com.cotacoes.longshort.controller.prices;

import java.util.List;

import com.cotacoes.longshort.model.Email;
import com.cotacoes.longshort.repository.EmailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailRepository emailRepository;

    @GetMapping()
    public List<Email> getEmails() {
        return emailRepository.findAll();
    }

    @PostMapping
    public Email registerEmail(@RequestBody Email email) {
        emailRepository.insert(email);
        return email;
    }
}
