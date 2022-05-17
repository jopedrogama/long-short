package com.cotacoes.longshort.controller.prices;

import java.util.List;

import com.cotacoes.longshort.model.StockModel;
import com.cotacoes.longshort.repository.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
public class StockController {

    @Autowired
    StockRepository stockRepository;

    @GetMapping
    public List<StockModel> getAll() {
        return stockRepository.findAll();
    }

    @GetMapping("/{stock}")
    public StockModel getStock(@PathVariable String stockCode) {
        return stockRepository.findAll().get(0);
    }

    @PostMapping
    public List<StockModel> createOrder(@RequestBody StockModel stockObject) {

        stockRepository.insert(stockObject);
        return stockRepository.findAll();
    }
}
