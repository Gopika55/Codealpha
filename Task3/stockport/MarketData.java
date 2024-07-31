package com.stockport;

import java.util.HashMap;
import java.util.Map;

public class MarketData {
    private Map<String, Stock> stocks = new HashMap<>();

    // Add stocks to the market
    public void addStock(Stock stock) {
        stocks.put(stock.getSymbol(), stock);
    }

    // Get stock price
    public double getStockPrice(String symbol) {
        Stock stock = stocks.get(symbol);
        return stock != null ? stock.getPrice() : 0;
    }

	
    

}

