package com.stocktrading;

import java.util.Scanner;

public class TradingPlatform {
    private Portfolio portfolio;
    private Market market;
    private Scanner scanner;

    public TradingPlatform() {
        portfolio = new Portfolio();
        market = new Market();
        scanner = new Scanner(System.in);
    }

    public void start() {
        String command;
        do {
            System.out.println("\nCommands: buy <symbol> <quantity>, sell <symbol> <quantity>, view, exit");
            System.out.print("Enter command: ");
            command = scanner.nextLine();
            processCommand(command);
        } while (!command.equalsIgnoreCase("exit"));
        scanner.close();
    }

    private void processCommand(String command) {
        String[] parts = command.split(" ");
        if (parts[0].equalsIgnoreCase("buy") && parts.length == 3) {
            String symbol = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            Stock stock = market.getStock(symbol);
            if (stock != null) {
                portfolio.buyStock(stock, quantity);
                System.out.println("Bought " + quantity + " shares of " + stock.getName());
            } else {
                System.out.println("Stock not found.");
            }
        } else if (parts[0].equalsIgnoreCase("sell") && parts.length == 3) {
            String symbol = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            Stock stock = market.getStock(symbol);
            if (stock != null) {
                portfolio.sellStock(stock, quantity);
                System.out.println("Sold " + quantity + " shares of " + stock.getName());
            } else {
                System.out.println("Stock not found.");
            }
        } else if (parts[0].equalsIgnoreCase("view")) {
            portfolio.displayPortfolio();
        } else {
            System.out.println("Invalid command.");
        }
    }

    public static void main(String[] args) {
        TradingPlatform platform = new TradingPlatform();
        platform.start();
    }
}

