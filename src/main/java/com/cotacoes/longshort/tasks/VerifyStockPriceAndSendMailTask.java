package com.cotacoes.longshort.tasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cotacoes.longshort.model.MailModel;
import com.cotacoes.longshort.model.StockModel;
import com.cotacoes.longshort.repository.StockRepository;
import com.cotacoes.longshort.service.Stock.ConvertStockListToText;
import com.cotacoes.longshort.service.Stock.StockPriceQuery;
import com.cotacoes.longshort.service.mailing.Implementation.SendGridService;

@Component
public class VerifyStockPriceAndSendMailTask {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    ConvertStockListToText convertStockListToText;

    @Autowired
    SendGridService sendGridService;

    @Async
    @Scheduled(fixedDelay = 60000)
    public void execute() {
        List<StockModel> stockList = stockRepository.findAll();
        stockList = new StockPriceQuery().getAllPrices(stockList);
        MailModel mail = convertStockListToText.execute(stockList);
        if (mail.isFilled()) {
            sendGridService.send(mail);
        }
    }
}
