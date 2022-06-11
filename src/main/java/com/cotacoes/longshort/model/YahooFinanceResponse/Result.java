package com.cotacoes.longshort.model.YahooFinanceResponse;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class Result {
    @JsonProperty("symbol")
    String symbol;
    @JsonProperty("regularMarketPrice")
    BigDecimal regularMarketPrice;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public void setRegularMarketPrice(BigDecimal regularMarketPrice) {
        this.regularMarketPrice = regularMarketPrice;
    }

}