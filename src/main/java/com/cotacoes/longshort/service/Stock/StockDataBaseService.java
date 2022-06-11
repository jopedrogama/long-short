package com.cotacoes.longshort.service.Stock;

import java.util.List;
import java.util.Optional;

import com.cotacoes.longshort.exceptions.BadRequestException;
import com.cotacoes.longshort.factory.StockFactory;
import com.cotacoes.longshort.model.StockModel;
import com.cotacoes.longshort.providers.IStockProvider;
import com.cotacoes.longshort.repository.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class StockDataBaseService {

    @Autowired
    StockRepository stockRepository;

    public StockModel insertStock(StockModel stock) {
        Optional<StockModel> queriedStock = stockRepository.findByStock(stock.getStock());

        if (queriedStock.isPresent()) {
            throw new BadRequestException("This ticker is already registered");
        }

        IStockProvider stockPriceQuery = StockFactory.getInstance(stock.getCountry());

        boolean doesThisStockExist = stockPriceQuery.doesStockExist(stock);

        if (!doesThisStockExist) {
            throw new BadRequestException("This stock ticker doesn't exist");
        }

        stockRepository.insert(stock);
        return stock;
    }

    public Optional<StockModel> find(String stockName) {
        return stockRepository.findByStock(stockName);
    }

    public List<StockModel> findAll() {
        return stockRepository.findAll();
    }

    public StockModel updateStock(StockModel stock) {
        Optional<StockModel> stockQueried = find(stock.getStock());

        if (!stockQueried.isPresent()) {
            throw new BadRequestException("Stock is not registed yet.");
        }

        stock.setId(stockQueried.get().getId());
        stockRepository.save(stock);
        return stock;
    }

    public void dontSendMail(StockModel stock) {
        stock.setShouldGetEmail(false);
        stockRepository.save(stock);
    }

    public void SendMailAgain(StockModel stock) {
        stock.setShouldGetEmail(true);
        stockRepository.save(stock);
    }
}
