package main;

import java.util.Scanner;

import service.BookingService;
import service.MovieService;
import service.PaymentService;
import service.UserService;

public class MovieTicketBookingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create Service Objects
        MovieService movieService = new MovieService();
        PaymentService paymentService = new PaymentService();
        BookingService bookingService = new BookingService(movieService, paymentService);
        UserService userService = new UserService(movieService, bookingService);

        int mainChoice;

        do {

            System.out.println("\n======================================");
            System.out.println("   MOVIE TICKET BOOKING SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Movie");
            System.out.println("2. User");
            System.out.println("3. View All Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter Choice : ");

            mainChoice = sc.nextInt();

            switch (mainChoice) {

                case 1:
                    movieService.addMovie();
                    break;

                case 2:
                    userMenu(sc, userService);
                    break;

                case 3:
                    bookingService.viewBookings();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (mainChoice != 4);

        sc.close();
    }

    // User Menu
    public static void userMenu(Scanner sc, UserService userService) {

        int choice;

        do {

            System.out.println("\n========== USER MENU ==========");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Movies");
            System.out.println("4. Book Ticket");
            System.out.println("5. Cancel Ticket");
            System.out.println("6. Logout");
            System.out.println("7. Back");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    userService.register();
                    break;

                case 2:
                    userService.login();
                    break;

                case 3:
                    userService.viewMovies();
                    break;

                case 4:
                    userService.bookTicket();
                    break;

                case 5:
                    userService.cancelTicket();
                    break;

                case 6:
                    userService.logout();
                    break;

                case 7:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

    }

}