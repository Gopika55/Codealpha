package com.stockport;

import java.util.Scanner;

import java.util.HashMap;
import java.util.Map;

public class StockTradingApp {
    private static MarketData marketData = new MarketData();
    private static TradingService tradingService = new TradingService(marketData);
    private static PortfolioTracker portfolioTracker = new PortfolioTracker(marketData);
    private static Map<String, User> users = new HashMap<>();
    private static User currentUser;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        marketData.addStock(new Stock("AAPL", 150.00));
        marketData.addStock(new Stock("GOOGL", 2800.00));

        
        System.out.print("Enter username to register: ");
        String username = scanner.nextLine();
        currentUser = new User(username);
        users.put(username, currentUser);

        while (true) {
            System.out.println("Welcome to the Stock Trading Platform");
            System.out.println("1. Buy Stock");
            System.out.println("2. Sell Stock");
            System.out.println("3. View Portfolio");
            System.out.println("4. Exit");
            
            System.out.println("Enter your choice");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter stock symbol: ");
                    String buySymbol = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int buyQuantity = scanner.nextInt();
                    scanner.nextLine(); 
                    tradingService.buyStock(currentUser, buySymbol, buyQuantity);
                    System.out.println("Stock bought successfully.");

                    break;
                case 2:
                    System.out.print("Enter stock symbol: ");
                    String sellSymbol = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int sellQuantity = scanner.nextInt();
                    scanner.nextLine(); 
                    tradingService.sellStock(currentUser, sellSymbol, sellQuantity);
                    System.out.println("Stock sold successfully.");

                    break;
                case 3:
                    portfolioTracker.displayPortfolio(currentUser);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
