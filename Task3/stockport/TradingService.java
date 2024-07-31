package com.stockport;

public class TradingService {
    private MarketData marketData;

    public TradingService(MarketData marketData) {
        this.marketData = marketData;
    }

    public void buyStock(User user, String symbol, int quantity) {
        double price = marketData.getStockPrice(symbol);
        if (price > 0) {
            user.getPortfolio().put(symbol, user.getPortfolio().getOrDefault(symbol, 0) + quantity);
            
            }

        }
    

    public void sellStock(User user, String symbol, int quantity) {
        int currentQuantity = user.getPortfolio().getOrDefault(symbol, 0);
        if (currentQuantity >= quantity) {
            user.getPortfolio().put(symbol, currentQuantity - quantity);
            
        }
    }
}

