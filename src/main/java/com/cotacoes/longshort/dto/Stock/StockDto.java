package com.cotacoes.longshort.dto.Stock;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cotacoes.longshort.model.Country;

import lombok.Data;

@Data
public class StockDto {

    @NotEmpty(message = "Stock code can not be empty")
    private String stock;

    @NotNull(message = "You must define minimum price for this stock")
    private BigDecimal minPrice;

    @NotNull(message = "You must define maximum price for this stock")
    private BigDecimal maxPrice;

    private Country country;
}
