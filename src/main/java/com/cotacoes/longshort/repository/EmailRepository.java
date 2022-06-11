package com.cotacoes.longshort.repository;

import com.cotacoes.longshort.model.RecieverEmailModel;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends MongoRepository<RecieverEmailModel, String> {

    Optional<RecieverEmailModel> findByEmail(String email);
}
