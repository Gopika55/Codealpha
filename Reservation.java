package com.Hotelreserv;

import java.util.Date;

public class Reservation {
    private int reservationId;
    private int roomId;
    private String userName;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalPrice;

    public Reservation(int reservationId, int roomId, String userName, Date checkInDate, Date checkOutDate, double totalPrice) {
        this.reservationId = reservationId;
        this.roomId = roomId;
        this.userName = userName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
    }

    public int getReservationId() {
        return reservationId;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getUserName() {
        return userName;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + "  Room ID: " + roomId + ", User: " +userName + ", Check-In: " + checkInDate + ", Check-Out: " + checkOutDate + ",Total Price: Rs." + totalPrice;
    }
}

