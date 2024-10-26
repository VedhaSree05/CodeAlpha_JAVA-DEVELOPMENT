package com.stocktrading;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<Stock, Integer> stocks = new HashMap<>();

    public void buyStock(Stock stock, int quantity) {
        stocks.put(stock, stocks.getOrDefault(stock, 0) + quantity);
    }

    public void sellStock(Stock stock, int quantity) {
        if (stocks.containsKey(stock) && stocks.get(stock) >= quantity) {
            stocks.put(stock, stocks.get(stock) - quantity);
            if (stocks.get(stock) == 0) {
                stocks.remove(stock);
            }
        }
    }

    public double calculateValue() {
        double totalValue = 0;
        for (Map.Entry<Stock, Integer> entry : stocks.entrySet()) {
            totalValue += entry.getKey().getPrice() * entry.getValue();
        }
        return totalValue;
    }

    public void displayPortfolio() {
        System.out.println("Your Portfolio:");
        for (Map.Entry<Stock, Integer> entry : stocks.entrySet()) {
            System.out.println(entry.getKey() + " - Quantity: " + entry.getValue());
        }
        System.out.println("Total Value: $" + calculateValue());
    }
}
