package model;

public class Movie {

    private int movieId;
    private String movieName;
    private String language;
    private String genre;
    private String duration;
    private String theatre;
    private String showTime;
    private double ticketPrice;

    // Default Constructor
    public Movie() {

    }

    // Parameterized Constructor
    public Movie(int movieId, String movieName, String language,
                 String genre, String duration,
                 String theatre, String showTime,
                 double ticketPrice) {

        this.movieId = movieId;
        this.movieName = movieName;
        this.language = language;
        this.genre = genre;
        this.duration = duration;
        this.theatre = theatre;
        this.showTime = showTime;
        this.ticketPrice = ticketPrice;
    }

    // Getters and Setters

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    // Display Method

    public void displayMovie() {

        System.out.println("--------------------------------------");
        System.out.println("Movie ID      : " + movieId);
        System.out.println("Movie Name    : " + movieName);
        System.out.println("Language      : " + language);
        System.out.println("Genre         : " + genre);
        System.out.println("Duration      : " + duration);
        System.out.println("Theatre       : " + theatre);
        System.out.println("Show Time     : " + showTime);
        System.out.println("Ticket Price  : ₹" + ticketPrice);
    }
}