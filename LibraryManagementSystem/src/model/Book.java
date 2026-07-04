package model;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private String category;
    private int quantity;
    private int availableCopies;

    // Default Constructor
    public Book() {

    }

    // Parameterized Constructor
    public Book(int bookId, String title, String author, String category,
            int quantity, int availableCopies) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.quantity = quantity;
        this.availableCopies = availableCopies;
    }

    // Getters and Setters

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    // Display Method

    public void displayBook() {

        System.out.println("--------------------------------------");
        System.out.println("Book ID          : " + bookId);
        System.out.println("Title            : " + title);
        System.out.println("Author           : " + author);
        System.out.println("Category         : " + category);
        System.out.println("Quantity         : " + quantity);
        System.out.println("Available Copies : " + availableCopies);
    }

}