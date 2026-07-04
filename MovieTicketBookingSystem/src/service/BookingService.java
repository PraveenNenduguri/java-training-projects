package service;

import java.util.HashMap;
import java.util.Scanner;

import exception.MovieNotFoundException;
import exception.SeatNotAvailableException;
import model.Booking;
import model.Movie;

public class BookingService {

    Scanner sc = new Scanner(System.in);

    private boolean[][] seats = new boolean[5][5];

    private HashMap<Integer, Booking> bookings = new HashMap<>();

    private MovieService movieService;
    private PaymentService paymentService;

    public BookingService(MovieService movieService,
                          PaymentService paymentService) {

        this.movieService = movieService;
        this.paymentService = paymentService;
    }

    // Book Ticket
    public void bookTicket(String userId) {

        try {

            movieService.viewMovies();

            System.out.print("\nEnter Booking ID : ");
            int bookingId = sc.nextInt();

            if (bookings.containsKey(bookingId)) {

                System.out.println("Booking ID already exists.");
                return;
            }

            System.out.print("Enter Movie ID : ");
            int movieId = sc.nextInt();

            Movie movie = movieService.getMovieById(movieId);

            if (movie == null) {
                throw new MovieNotFoundException("Movie Not Found.");
            }

            System.out.println("\nSelected Movie : " + movie.getMovieName());
            System.out.println("Theatre : " + movie.getTheatre());
            System.out.println("Show Time : " + movie.getShowTime());

            displaySeats();

            System.out.print("\nEnter Row (1-5): ");
            int row = sc.nextInt() - 1;

            System.out.print("Enter Column (1-5): ");
            int column = sc.nextInt() - 1;

            if (row < 0 || row >= 5 || column < 0 || column >= 5) {

                System.out.println("Invalid Seat Number.");
                return;
            }

            if (seats[row][column]) {
                throw new SeatNotAvailableException("Seat Already Booked.");
            }

            double amount = movie.getTicketPrice();

            System.out.println("\nTicket Price : ₹" + amount);

            System.out.println("\nSelect Payment Mode");
            System.out.println("1. Card");
            System.out.println("2. UPI");
            System.out.println("3. Wallet");

            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();

            String paymentMode = "";

            switch (choice) {

                case 1:
                    paymentService.cardPayment(amount);
                    paymentMode = "Card";
                    break;

                case 2:
                    paymentService.upiPayment(amount);
                    paymentMode = "UPI";
                    break;

                case 3:
                    paymentService.walletPayment(amount);
                    paymentMode = "Wallet";
                    break;

                default:
                    System.out.println("Invalid Payment Choice.");
                    return;
            }

            seats[row][column] = true;

            Booking booking = new Booking(
                    bookingId,
                    userId,
                    movieId,
                    movie.getTheatre(),
                    movie.getShowTime(),
                    row,
                    column,
                    amount,
                    paymentMode,
                    "Booked");

            bookings.put(bookingId, booking);

            System.out.println("\n=================================");
            System.out.println("Booking Successful!");
            System.out.println("Seat Number : " + (row + 1) + "-" + (column + 1));
            System.out.println("Enjoy Your Movie!");
            System.out.println("=================================");

        } catch (MovieNotFoundException | SeatNotAvailableException e) {

            System.out.println(e.getMessage());

        }

    }

    // Display Seat Layout
    public void displaySeats() {

        System.out.println("\n========== SCREEN ==========\n");

        for (int i = 0; i < seats.length; i++) {

            for (int j = 0; j < seats[i].length; j++) {

                if (seats[i][j]) {

                    System.out.print(" X ");

                } else {

                    System.out.print(" O ");
                }
            }

            System.out.println();
        }

        System.out.println("\nO = Available");
        System.out.println("X = Booked");
    }
    
    // Cancel Ticket
    public void cancelTicket(String userId) {

        System.out.print("Enter Booking ID : ");
        int bookingId = sc.nextInt();

        if (!bookings.containsKey(bookingId)) {

            System.out.println("Booking Not Found.");
            return;
        }

        Booking booking = bookings.get(bookingId);

        if (!booking.getUserId().equals(userId)) {

            System.out.println("This booking does not belong to you.");
            return;
        }

        // Make the seat available again
        seats[booking.getRow()][booking.getColumn()] = false;

        booking.setBookingStatus("Cancelled");

        bookings.remove(bookingId);

        System.out.println("\n===============================");
        System.out.println("Ticket Cancelled Successfully.");
        System.out.println("===============================");
    }

    // View All Bookings
    public void viewBookings() {

        if (bookings.isEmpty()) {

            System.out.println("No Bookings Available.");
            return;
        }

        System.out.println("\n========== BOOKING DETAILS ==========");

        for (Booking booking : bookings.values()) {

            booking.displayBooking();
        }
    }

    // View Seats
    public void viewSeatStatus() {

        displaySeats();
    }

    // Getter
    public HashMap<Integer, Booking> getBookings() {

        return bookings;
    }

}