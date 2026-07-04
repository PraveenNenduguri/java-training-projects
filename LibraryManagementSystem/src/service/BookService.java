package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import exception.BookNotFoundException;
import interfaces.AdminOperations;
import model.Book;

public class BookService implements AdminOperations {

    Scanner sc = new Scanner(System.in);

    private ArrayList<Book> books = new ArrayList<>();

    // Add Book
    @Override
    public void addBook() {

        System.out.print("Enter Book ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        // Check Duplicate ID
        for (Book book : books) {
            if (book.getBookId() == id) {
                System.out.println("Book ID already exists.");
                return;
            }
        }

        System.out.print("Enter Book Title : ");
        String title = sc.nextLine();

        System.out.print("Enter Author : ");
        String author = sc.nextLine();

        System.out.print("Enter Category : ");
        String category = sc.nextLine();

        System.out.print("Enter Quantity : ");
        int quantity = sc.nextInt();

        Book book = new Book(id, title, author, category, quantity, quantity);

        books.add(book);

        System.out.println("\nBook Added Successfully.");
    }

    // Update Book
    @Override
    public void updateBook() {

        try {

            System.out.print("Enter Book ID to Update : ");
            int id = sc.nextInt();
            sc.nextLine();

            for (Book book : books) {

                if (book.getBookId() == id) {

                    System.out.print("Enter New Title : ");
                    book.setTitle(sc.nextLine());

                    System.out.print("Enter New Author : ");
                    book.setAuthor(sc.nextLine());

                    System.out.print("Enter New Category : ");
                    book.setCategory(sc.nextLine());

                    System.out.print("Enter New Quantity : ");
                    int quantity = sc.nextInt();

                    book.setQuantity(quantity);
                    book.setAvailableCopies(quantity);

                    System.out.println("Book Updated Successfully.");
                    return;
                }
            }

            throw new BookNotFoundException("Book Not Found.");

        } catch (BookNotFoundException e) {

            System.out.println(e.getMessage());

        }

    }

    // Delete Book
    @Override
    public void deleteBook() {

        try {

            System.out.print("Enter Book ID : ");
            int id = sc.nextInt();

            Iterator<Book> iterator = books.iterator();

            while (iterator.hasNext()) {

                Book book = iterator.next();

                if (book.getBookId() == id) {

                    iterator.remove();

                    System.out.println("Book Deleted Successfully.");
                    return;
                }

            }

            throw new BookNotFoundException("Book Not Found.");

        } catch (BookNotFoundException e) {

            System.out.println(e.getMessage());

        }

    }

    // Search Book
    @Override
    public void searchBook() {

        try {

            System.out.print("Enter Book ID : ");
            int id = sc.nextInt();

            for (Book book : books) {

                if (book.getBookId() == id) {

                    book.displayBook();
                    return;
                }

            }

            throw new BookNotFoundException("Book Not Found.");

        } catch (BookNotFoundException e) {

            System.out.println(e.getMessage());

        }

    }

    // View All Books
    @Override
    public void viewAllBooks() {

        if (books.isEmpty()) {

            System.out.println("No Books Available.");
            return;
        }

        System.out.println("\n========= BOOK LIST =========");

        for (Book book : books) {

            book.displayBook();
        }

    }

    // Getter
    public ArrayList<Book> getBooks() {

        return books;
    }

}