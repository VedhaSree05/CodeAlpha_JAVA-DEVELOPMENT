package com.hotelreservation;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms(); // Initialize some rooms
    }

    private void initializeRooms() {
        rooms.add(new Room("101", "Single", 100));
        rooms.add(new Room("102", "Double", 150));
        rooms.add(new Room("201", "Suite", 250));
        rooms.add(new Room("202", "Double", 150));
    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public void makeReservation(Room room, String guestName, LocalDate startDate, LocalDate endDate) {
        Reservation reservation = new Reservation(room, startDate, endDate, guestName);
        reservations.add(reservation);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}

