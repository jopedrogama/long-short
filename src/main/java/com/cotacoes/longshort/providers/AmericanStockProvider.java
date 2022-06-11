package com.cotacoes.longshort.providers;

import org.springframework.web.client.RestTemplate;

import com.cotacoes.longshort.model.StockModel;
import com.cotacoes.longshort.model.YahooFinanceResponse.YahooResponse;

public class AmericanStockProvider implements IStockProvider {

    @Override
    public StockModel getPrice(StockModel stock) {
        String url = "https://query1.finance.yahoo.com/v7/finance/quote?symbols={stock}";

        YahooResponse response = new RestTemplate().getForObject(url, YahooResponse.class, stock.getStock());
        stock.setCurrentPrice(response
                .getQuoteResponse()
                .getResult()
                .get(0)
                .getRegularMarketPrice());

        return stock;
    }

    @Override
    public boolean doesStockExist(StockModel stock) {
        String url = "https://query1.finance.yahoo.com/v7/finance/quote?symbols={stock}";
        YahooResponse response = new RestTemplate().getForObject(url, YahooResponse.class, stock.getStock());
        if (response.getQuoteResponse().getResult().isEmpty()) {
            return false;
        }
        return true;
    }

}
