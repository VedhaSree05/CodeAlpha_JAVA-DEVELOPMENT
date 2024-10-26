package com.hotelreservation;

import java.time.LocalDate;

public class Reservation {
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;
    private String guestName;

    public Reservation(Room room, LocalDate startDate, LocalDate endDate, String guestName) {
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guestName = guestName;
        room.setAvailable(false); // Mark room as reserved
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getGuestName() {
        return guestName;
    }

    @Override
    public String toString() {
        return "Reservation for " + guestName + ": " + room + ", From: " + startDate + " To: " + endDate;
    }
}

