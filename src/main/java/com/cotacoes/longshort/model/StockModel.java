package com.cotacoes.longshort.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("stocks")
public class StockModel {

    @Id
    private String id;

    @Indexed(unique = true)
    private String stock;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;

    public StockModel(String stock, BigDecimal minPrice, BigDecimal maxPrice) {
        this.stock = stock;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }
}
