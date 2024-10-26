package com.hotelreservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {
    private Hotel hotel;
    private Scanner scanner;

    public HotelReservationSystem() {
        hotel = new Hotel();
        scanner = new Scanner(System.in);
    }

    public void start() {
        String command;
        do {
            System.out.println("\nCommands: search, reserve, view reservations, exit");
            System.out.print("Enter command: ");
            command = scanner.nextLine();
            processCommand(command);
        } while (!command.equalsIgnoreCase("exit"));
        scanner.close();
    }

    private void processCommand(String command) {
        switch (command.toLowerCase()) {
            case "search":
                searchAvailableRooms();
                break;
            case "reserve":
                makeReservation();
                break;
            case "view reservations":
                viewReservations();
                break;
            default:
                if (!command.equalsIgnoreCase("exit")) {
                    System.out.println("Invalid command.");
                }
        }
    }

    private void searchAvailableRooms() {
        List<Room> availableRooms = hotel.getAvailableRooms();
        if (availableRooms.isEmpty()) {
            System.out.println("No available rooms.");
        } else {
            System.out.println("Available Rooms:");
            for (Room room : availableRooms) {
                System.out.println(room);
            }
        }
    }

    private void makeReservation() {
        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine();
        
        searchAvailableRooms();

        System.out.print("Enter room number to reserve: ");
        String roomNumber = scanner.nextLine();
        Room room = hotel.getAvailableRooms().stream()
            .filter(r -> r.getRoomNumber().equalsIgnoreCase(roomNumber))
            .findFirst()
            .orElse(null);

        if (room != null) {
            System.out.print("Enter start date (YYYY-MM-DD): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine());
            System.out.print("Enter end date (YYYY-MM-DD): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine());

            hotel.makeReservation(room, guestName, startDate, endDate);

            // Process payment
            System.out.print("Enter payment method (Credit Card/PayPal): ");
            String paymentMethod = scanner.nextLine();
            Payment payment = new Payment(room.getPrice(), paymentMethod);
            if (payment.processPayment()) {
                System.out.println("Reservation successful!");
            } else {
                System.out.println("Payment failed.");
            }
        } else {
            System.out.println("Room not available.");
        }
    }

    private void viewReservations() {
        List<Reservation> reservations = hotel.getReservations();
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            System.out.println("Current Reservations:");
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }

    public static void main(String[] args) {
        HotelReservationSystem system = new HotelReservationSystem();
        system.start();
    }
}
