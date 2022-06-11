package com.cotacoes.longshort.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Document("stocks")
public class StockModel {

    @Id
    private String id;

    @Indexed(unique = true)
    private String stock;
    private Country country = Country.BRAZIL;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private BigDecimal currentPrice;
    private boolean shouldGetEmail = true;

    // public StockModel(String stock, BigDecimal minPrice, BigDecimal maxPrice) {
    // this.stock = stock;
    // this.minPrice = minPrice;
    // this.maxPrice = maxPrice;
    // }

    // public StockModel(String stock, BigDecimal minPrice, BigDecimal maxPrice,
    // String country) {
    // this.stock = stock;
    // this.minPrice = minPrice;
    // this.maxPrice = maxPrice;
    // this.country = Country.getCountry(country);
    // }
}
