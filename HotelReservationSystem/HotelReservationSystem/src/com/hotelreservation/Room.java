package com.hotelreservation;

public class Room {
    private String roomNumber;
    private String category; // e.g., "Single", "Double", "Suite"
    private boolean available;
    private double price;

    public Room(String roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.available = true; // All rooms are available when created
        this.price = price;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " (" + category + ") - $" + price + " - " + (available ? "Available" : "Not Available");
    }
}
