package com.Hotelreserv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private HotelReservation controller;

    public UserInterface() {
        scanner = new Scanner(System.in);
        controller = new HotelReservation();
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    controller.displayAvailableRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewBookingDetails();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n--- Hotel Reservation System ---");
        System.out.println("1. Search Available Rooms");
        System.out.println("2. Make a Reservation");
        System.out.println("3. View Booking Details");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    private void makeReservation() {
        System.out.print("Enter room ID: ");
        int roomId = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter check-in date (yyyy-MM-dd): ");
        Date checkInDate = parseDate(scanner.nextLine());

        System.out.print("Enter check-out date (yyyy-MM-dd): ");
        Date checkOutDate = parseDate(scanner.nextLine());

        controller.makeReservation(roomId, userName, checkInDate, checkOutDate);
    }

    private void viewBookingDetails() {
        System.out.print("Enter reservation ID: ");
        int reservationId = Integer.parseInt(scanner.nextLine());
        controller.viewBookingDetails(reservationId);
    }

    private Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return null;
        }
    }
}

