package com.cotacoes.longshort.repository;

import java.util.Optional;

import com.cotacoes.longshort.model.StockModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends MongoRepository<StockModel, String> {

    Optional<StockModel> findByStock(String stock);
}
