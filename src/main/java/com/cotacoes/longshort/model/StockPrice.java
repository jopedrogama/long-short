package com.cotacoes.longshort.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockPrice {

    private String stock;
    private BigDecimal price;

}
