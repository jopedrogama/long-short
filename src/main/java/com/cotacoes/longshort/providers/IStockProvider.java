package com.cotacoes.longshort.providers;

import com.cotacoes.longshort.model.StockModel;

public interface IStockProvider {
    public StockModel getPrice(StockModel stock);

    public boolean doesStockExist(StockModel stock);
}
