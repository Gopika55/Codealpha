package com.stockport;

import java.util.Map;

public class PortfolioTracker {
    private MarketData marketData;

    public PortfolioTracker(MarketData marketData) {
        this.marketData = marketData;
    }

    public void displayPortfolio(User user) {
        System.out.println("Portfolio for " + user.getUsername());
        double totalValue = 0;
        for (Map.Entry<String, Integer> entry : user.getPortfolio().entrySet()) {
            String symbol = entry.getKey();
            int quantity = entry.getValue();
            double price = marketData.getStockPrice(symbol);
            double value = price * quantity;
            totalValue += value;
            System.out.println(symbol + ": " + quantity + " Rs." + price + " each, Total: " + value);
        }
        System.out.println("Total Portfolio Value: " + totalValue);
    }
}

