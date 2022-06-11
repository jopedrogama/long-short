package com.cotacoes.longshort.service.email;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cotacoes.longshort.exceptions.BadRequestException;
import com.cotacoes.longshort.model.RecieverEmailModel;
import com.cotacoes.longshort.repository.EmailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    public List<RecieverEmailModel> getAll() {
        return emailRepository.findAll();
    }

    public RecieverEmailModel insert(RecieverEmailModel emailModel) {
        return emailRepository.insert(emailModel);
    }

    public List<RecieverEmailModel> insertThroughFile(MultipartFile file) {
        List<String> emailList = listEmails(file);

        emailList.forEach(email -> {
            RecieverEmailModel reciever = new RecieverEmailModel();
            reciever.setEmail(email);
            insert(reciever);
        });
        return getAll();
    }

    public List<String> getEmailList() {
        return emailRepository.findAll().stream().map(RecieverEmailModel::getEmail).collect(Collectors.toList());
    }

    private List<String> listEmails(MultipartFile file) {
        List<String> emails = new ArrayList<String>();
        try {
            InputStream inputStream = file.getInputStream();
            new BufferedReader(new InputStreamReader(inputStream)).lines().forEach(line -> emails.add(line));
        } catch (Exception e) {
            throw new BadRequestException("It is not possible to read file");
        }
        return emails;
    }

    public List<RecieverEmailModel> delete(RecieverEmailModel email) {
        Optional<RecieverEmailModel> query = emailRepository.findByEmail(email.getEmail());
        if (query.isPresent()) {
            emailRepository.deleteById(query.get().getId());
        } else {
            throw new BadRequestException("This email is not registered");
        }
        return getAll();
    }
}
