package com.cotacoes.longshort.repository;

import com.cotacoes.longshort.model.Email;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmailRepository extends MongoRepository<Email, String> {

}
