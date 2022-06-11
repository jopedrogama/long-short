package com.cotacoes.longshort.controller;

import java.util.List;

import javax.validation.Valid;

import com.cotacoes.longshort.dto.Stock.StockDto;
import com.cotacoes.longshort.dto.Stock.StockMapper;
import com.cotacoes.longshort.model.StockModel;
import com.cotacoes.longshort.service.Stock.StockDataBaseService;
import com.cotacoes.longshort.service.Stock.StockPriceQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
public class StockController {

    @Autowired
    StockDataBaseService stockDataBaseService;

    @Autowired
    StockMapper stockMapper;

    @GetMapping
    public List<StockModel> getAll() {
        return stockDataBaseService.findAll();
    }

    @GetMapping("/{stock}")
    public StockModel getStock(@PathVariable String stockCode) {
        return stockDataBaseService.findAll().get(0);
    }

    @PostMapping
    public StockModel createStockAlert(@Valid @RequestBody StockDto stockDto) {
        StockModel stockModel = stockMapper.toModel(stockDto);
        stockDataBaseService.insertStock(stockModel);
        return new StockPriceQuery().getPrice(stockModel);
    }

    @PutMapping
    public StockModel updateStock(@Valid @RequestBody StockModel stockObject) {
        stockDataBaseService.updateStock(stockObject);
        return new StockPriceQuery().getPrice(stockObject);
    }

}
