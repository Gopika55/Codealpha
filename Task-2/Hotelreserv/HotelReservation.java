package com.Hotelreserv;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelReservation {
    private List<Room> rooms;
    private List<Reservation> reservations;
    private int reservationCounter = 1;

    public HotelReservation() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        rooms.add(new Room(101, "Single", true, 100.0));
        rooms.add(new Room(102, "Double", true, 150.0));
        rooms.add(new Room(103, "Suite", true, 200.0));
    }

    public void displayAvailableRooms() {
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    public void makeReservation(int roomId, String userName, Date checkInDate, Date checkOutDate) {
        Room room = findRoomById(roomId);
        if (room != null && room.isAvailable()) {
            double totalPrice = calculateTotalPrice(room.getPrice(), checkInDate, checkOutDate);
            reservations.add(new Reservation(reservationCounter++, roomId, userName, checkInDate, checkOutDate, totalPrice));
            room.setAvailable(false);
            System.out.println("Reservation successful!");
            System.out.println("Total Price: Rs." + totalPrice);
        } else {
            System.out.println("Room not available or not found.");
        }
    }

    public void viewBookingDetails(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                System.out.println(reservation);
                return;
            }
        }
        System.out.println("Reservation not found.");
    }

    private Room findRoomById(int roomId) {
        for (Room room : rooms) {
            if (room.getRoomId() == roomId) {
                return room;
            }
        }
        return null;
    }

    private double calculateTotalPrice(double price, Date checkInDate, Date checkOutDate) {
        long diff = checkOutDate.getTime() - checkInDate.getTime();
        long days = diff / (1000 * 60 * 60 * 24);
        return price * days;
    }
}

