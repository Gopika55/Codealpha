package com.Hotelreserv;


public class Room {
    private int roomId;
    private String type;
    private boolean isAvailable;
    private double price;

    public Room(int roomId, String type, boolean isAvailable, double price) {
        this.roomId = roomId;
        this.type = type;
        this.isAvailable = isAvailable;
        this.price = price;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Room ID: " + roomId + ", Type: " + type + ", Available: " + isAvailable + ", Price: $" + price;
    }

	public boolean isAvailable1() {
		// TODO Auto-generated method stub
		return false;
	}
}
