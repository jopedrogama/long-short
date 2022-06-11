package com.cotacoes.longshort.factory;

import com.cotacoes.longshort.model.Country;
import com.cotacoes.longshort.providers.AmericanStockProvider;
import com.cotacoes.longshort.providers.BrazilianStockProvider;
import com.cotacoes.longshort.providers.IStockProvider;

public class StockFactory {

    public static IStockProvider getInstance(Country country) {

        switch (country) {
            case BRAZIL:
                return new BrazilianStockProvider();
            case USA:
                return new AmericanStockProvider();
            default:
                return new BrazilianStockProvider();
        }
    }
}
