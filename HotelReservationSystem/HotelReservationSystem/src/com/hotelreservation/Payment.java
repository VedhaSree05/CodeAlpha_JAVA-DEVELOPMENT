package com.hotelreservation;

public class Payment {
    private double amount;
    private String method; // e.g., "Credit Card", "PayPal"

    public Payment(double amount, String method) {
        this.amount = amount;
        this.method = method;
    }

    public boolean processPayment() {
        // Simulate payment processing (always return true for simplicity)
        System.out.println("Processing payment of $" + amount + " using " + method + "...");
        return true; // Assume payment is successful
    }
}

