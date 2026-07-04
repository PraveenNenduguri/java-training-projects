package model;

public class Booking {

    private int bookingId;
    private String userId;
    private int movieId;
    private String theatre;
    private String showTime;
    private int row;
    private int column;
    private double amount;
    private String paymentMode;
    private String bookingStatus;

    // Default Constructor
    public Booking() {

    }

    // Parameterized Constructor
    public Booking(int bookingId, String userId,
                   int movieId, String theatre,
                   String showTime, int row,
                   int column, double amount,
                   String paymentMode,
                   String bookingStatus) {

        this.bookingId = bookingId;
        this.userId = userId;
        this.movieId = movieId;
        this.theatre = theatre;
        this.showTime = showTime;
        this.row = row;
        this.column = column;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.bookingStatus = bookingStatus;
    }

    // Getters and Setters

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTheatre() {
        return theatre;
    }

    public void setTheatre(String theatre) {
        this.theatre = theatre;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    // Display Method

    public void displayBooking() {

        System.out.println("-----------------------------------");
        System.out.println("Booking ID    : " + bookingId);
        System.out.println("User ID       : " + userId);
        System.out.println("Movie ID      : " + movieId);
        System.out.println("Theatre       : " + theatre);
        System.out.println("Show Time     : " + showTime);
        System.out.println("Seat          : " + (row + 1) + "-" + (column + 1));
        System.out.println("Amount        : ₹" + amount);
        System.out.println("Payment Mode  : " + paymentMode);
        System.out.println("Status        : " + bookingStatus);
    }
}