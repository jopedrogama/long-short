package com.cotacoes.longshort.service.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.cotacoes.longshort.model.Actions;
import com.cotacoes.longshort.model.MailModel;
import com.cotacoes.longshort.model.StockModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvertStockListToText {

    @Autowired
    StockDataBaseService stockDataBaseService;

    public MailModel execute(List<StockModel> listStocks) {

        List<StockModel> sell = new ArrayList<StockModel>();
        List<StockModel> buy = new ArrayList<StockModel>();

        listStocks.forEach(stock -> {

            if (stock.isShouldGetEmail()) {

                Actions action = isAGoodPrice(stock);

                if (action == Actions.BUY) {
                    buy.add(stock);
                    stockDataBaseService.dontSendMail(stock);

                }

                if (action == Actions.SELL) {
                    sell.add(stock);
                    stockDataBaseService.dontSendMail(stock);

                }

            } else {
                if (Objects.isNull(isAGoodPrice(stock))) {
                    stockDataBaseService.SendMailAgain(stock);
                }
            }

        });

        String body = bodyConstructor(buy, sell);
        String title = "";

        if (!buy.isEmpty() || !sell.isEmpty()) {
            title = "STOCK OPERATIONS";
        }

        MailModel mailModel = MailModel.builder()
                .subject(title)
                .body(body)
                .build();

        return mailModel;
    }

    private Actions isAGoodPrice(StockModel stock) {
        if ((stock.getCurrentPrice()).compareTo(stock.getMinPrice()) == -1) {
            return Actions.BUY;
        }
        if ((stock.getCurrentPrice()).compareTo(stock.getMaxPrice()) == 1) {
            return Actions.SELL;
        }
        return null;
    }

    private String bodyConstructor(List<StockModel> buyStocks, List<StockModel> sellStocks) {
        ArrayList<String> text = new ArrayList<String>();

        if (!buyStocks.isEmpty()) {
            text = setBuyMessage(buyStocks);
        }

        if (!sellStocks.isEmpty()) {
            text.addAll(setSellMessage(sellStocks));
        }

        return String.join(" ", text);
    }

    private ArrayList<String> setBuyMessage(List<StockModel> stockList) {

        ArrayList<String> message = new ArrayList<String>();
        message.add("<h2> BUY </h2>");

        stockList.forEach(stock -> {
            message.add("<br>" + stock.getStock() + " - Actual price: R$" +
                    stock.getCurrentPrice()
                    + ". - Defined price: R$" + stock.getMinPrice());
        });
        return message;
    }

    private ArrayList<String> setSellMessage(List<StockModel> stockList) {

        ArrayList<String> message = new ArrayList<String>();
        message.add("<h2> SELL </h2>");

        stockList.forEach(stock -> {
            message.add("<br>" + stock.getStock() + " - Actual price: R$" +
                    stock.getCurrentPrice()
                    + ". - Defined price: R$" + stock.getMaxPrice());
        });
        return message;
    }

}
