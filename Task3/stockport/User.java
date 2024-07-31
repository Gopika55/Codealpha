package com.stockport;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String username;
    private Map<String, Integer> portfolio; // Stock symbol and quantity

    public User(String username) {
        this.username = username;
        this.portfolio = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public Map<String, Integer> getPortfolio() {
        return portfolio;
    }

    public void addStock(String symbol, int quantity) {
        portfolio.put(symbol, portfolio.getOrDefault(symbol, 0) + quantity);
    }

    public void removeStock(String symbol, int quantity) {
        int currentQuantity = portfolio.getOrDefault(symbol, 0);
        if (currentQuantity >= quantity) {
            portfolio.put(symbol, currentQuantity - quantity);
        }
    }
}

