package com.cotacoes.longshort.repository;

import com.cotacoes.longshort.model.StockModel;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockRepository extends MongoRepository<StockModel, String> {

}
