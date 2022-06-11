package com.cotacoes.longshort.service.Stock;

import java.util.ArrayList;
import java.util.List;

import com.cotacoes.longshort.factory.StockFactory;
import com.cotacoes.longshort.model.StockModel;
import com.cotacoes.longshort.providers.IStockProvider;

public class StockPriceQuery {

    public StockModel getPrice(StockModel stock) {
        IStockProvider stockPriceQuery = StockFactory.getInstance(stock.getCountry());

        StockModel stockPrice = stockPriceQuery.getPrice(stock);
        return stockPrice;
    }

    public List<StockModel> getAllPrices(List<StockModel> stockList) {
        List<StockModel> listWithCurrentPrice = new ArrayList<StockModel>();

        stockList.forEach(stock -> {
            listWithCurrentPrice.add(getPrice(stock));
        });

        return listWithCurrentPrice;
    }

}
