package com.stocktrading;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private List<Stock> stocks;

    public Market() {
        stocks = new ArrayList<>();
        stocks.add(new Stock("AAPL", "Apple Inc.", 150.00));
        stocks.add(new Stock("GOOGL", "Alphabet Inc.", 2800.00));
        stocks.add(new Stock("AMZN", "Amazon.com Inc.", 3300.00));
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public Stock getStock(String symbol) {
        for (Stock stock : stocks) {
            if (stock.getSymbol().equalsIgnoreCase(symbol)) {
                return stock;
            }
        }
        return null;
    }
}
