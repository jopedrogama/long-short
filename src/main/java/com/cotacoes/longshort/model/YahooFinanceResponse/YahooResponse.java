package com.cotacoes.longshort.model.YahooFinanceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class YahooResponse {
    @JsonProperty("quoteResponse")
    private QuoteResponse quoteResponse;
}
