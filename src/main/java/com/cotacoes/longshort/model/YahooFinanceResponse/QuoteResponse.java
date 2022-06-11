package com.cotacoes.longshort.model.YahooFinanceResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class QuoteResponse {

    @JsonProperty("error")
    private Boolean error;

    @JsonProperty("result")
    private List<Result> result;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

}
