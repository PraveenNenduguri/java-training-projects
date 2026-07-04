package service;

import java.util.HashMap;
import java.util.Scanner;

import exception.UserNotFoundException;
import interfaces.UserOperations;
import model.User;

public class UserService implements UserOperations {

    Scanner sc = new Scanner(System.in);

    private HashMap<String, User> users = new HashMap<>();

    private MovieService movieService;
    private BookingService bookingService;

    // Logged-in User
    private String currentUserId;

    // Constructor
    public UserService(MovieService movieService, BookingService bookingService) {

        this.movieService = movieService;
        this.bookingService = bookingService;
    }

    // Register User
    @Override
    public void register() {

        System.out.print("Enter User ID : ");
        String userId = sc.next();

        if (users.containsKey(userId)) {
            System.out.println("User ID already exists.");
            return;
        }

        sc.nextLine();

        System.out.print("Enter Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Password : ");
        String password = sc.nextLine();

        System.out.print("Enter Phone Number : ");
        String phone = sc.nextLine();

        User user = new User(userId, name, password, phone);

        users.put(userId, user);

        System.out.println("Registration Successful.");
    }

    // Login
    @Override
    public void login() {

        try {

            System.out.print("Enter User ID : ");
            String userId = sc.next();

            System.out.print("Enter Password : ");
            String password = sc.next();

            if (!users.containsKey(userId)) {
                throw new UserNotFoundException("User Not Found.");
            }

            User user = users.get(userId);

            if (user.getPassword().equals(password)) {

                currentUserId = userId;

                System.out.println("Login Successful.");

            } else {

                System.out.println("Invalid Password.");
            }

        } catch (UserNotFoundException e) {

            System.out.println(e.getMessage());

        }

    }

    // View Movies
    @Override
    public void viewMovies() {

        movieService.viewMovies();
    }

    // Book Ticket
    @Override
    public void bookTicket() {

        if (currentUserId == null) {

            System.out.println("Please Login First.");
            return;
        }

        bookingService.bookTicket(currentUserId);
    }

    // Cancel Ticket
    @Override
    public void cancelTicket() {

        if (currentUserId == null) {

            System.out.println("Please Login First.");
            return;
        }

        bookingService.cancelTicket(currentUserId);
    }

    // Logout
    @Override
    public void logout() {

        if (currentUserId == null) {

            System.out.println("No User is Logged In.");
            return;
        }

        currentUserId = null;

        System.out.println("Logged Out Successfully.");
    }

    // Getter for Logged-in User
    public String getCurrentUserId() {

        return currentUserId;
    }

    // Getter for Users
    public HashMap<String, User> getUsers() {

        return users;
    }

}