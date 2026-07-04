package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import exception.BookNotAvailableException;
import model.Book;
import model.BookIssue;

public class IssueService {

    Scanner sc = new Scanner(System.in);

    private HashMap<Integer, BookIssue> issuedBooks = new HashMap<>();
    private HashMap<String, ArrayList<Book>> borrowedBooks = new HashMap<>();

    private BookService bookService;

    public IssueService(BookService bookService) {
        this.bookService = bookService;
    }

    // Issue Book
    public void issueBook(String studentId) {

        try {

            System.out.print("Enter Issue ID : ");
            int issueId = sc.nextInt();

            if (issuedBooks.containsKey(issueId)) {
                System.out.println("Issue ID already exists.");
                return;
            }

            System.out.print("Enter Book ID : ");
            int bookId = sc.nextInt();
            sc.nextLine();

            Book selectedBook = null;

            for (Book book : bookService.getBooks()) {

                if (book.getBookId() == bookId) {
                    selectedBook = book;
                    break;
                }
            }

            if (selectedBook == null) {
                System.out.println("Book Not Found.");
                return;
            }

            if (selectedBook.getAvailableCopies() <= 0) {
                throw new BookNotAvailableException("Book is currently not available.");
            }

            System.out.print("Enter Issue Date : ");
            String issueDate = sc.nextLine();

            System.out.print("Enter Due Date : ");
            String dueDate = sc.nextLine();

            BookIssue issue = new BookIssue(
                    issueId,
                    studentId,
                    bookId,
                    issueDate,
                    dueDate,
                    "",
                    0);

            issuedBooks.put(issueId, issue);

            borrowedBooks.putIfAbsent(studentId, new ArrayList<>());
            borrowedBooks.get(studentId).add(selectedBook);

            selectedBook.setAvailableCopies(selectedBook.getAvailableCopies() - 1);

            System.out.println("Book Issued Successfully.");

        } catch (BookNotAvailableException e) {

            System.out.println(e.getMessage());

        }

    }

    // Return Book
    public void returnBook(String studentId) {

        System.out.print("Enter Issue ID : ");
        int issueId = sc.nextInt();
        sc.nextLine();

        if (!issuedBooks.containsKey(issueId)) {
            System.out.println("Issue Record Not Found.");
            return;
        }

        BookIssue issue = issuedBooks.get(issueId);

        if (!issue.getStudentId().equals(studentId)) {
            System.out.println("This book was not issued to you.");
            return;
        }

        System.out.print("Enter Return Date : ");
        String returnDate = sc.nextLine();

        issue.setReturnDate(returnDate);

        System.out.print("Enter Late Days : ");
        int lateDays = sc.nextInt();

        double fine = calculateFine(lateDays);
        issue.setFine(fine);

        for (Book book : bookService.getBooks()) {

            if (book.getBookId() == issue.getBookId()) {

                book.setAvailableCopies(book.getAvailableCopies() + 1);
                break;
            }
        }

        ArrayList<Book> borrowed = borrowedBooks.get(studentId);

        if (borrowed != null) {

            borrowed.removeIf(book -> book.getBookId() == issue.getBookId());

            if (borrowed.isEmpty()) {
                borrowedBooks.remove(studentId);
            }
        }

        issuedBooks.remove(issueId);

        System.out.println("Book Returned Successfully.");

        if (fine > 0) {
            System.out.println("Fine : ₹" + fine);
        }

    }

    // Renew Book
    public void renewBook() {

        System.out.print("Enter Issue ID : ");
        int issueId = sc.nextInt();
        sc.nextLine();

        if (!issuedBooks.containsKey(issueId)) {
            System.out.println("Issue Record Not Found.");
            return;
        }

        System.out.print("Enter New Due Date : ");
        String newDueDate = sc.nextLine();

        issuedBooks.get(issueId).setDueDate(newDueDate);

        System.out.println("Book Renewed Successfully.");
    }

    // View All Issued Books
    public void viewIssuedBooks() {

        if (issuedBooks.isEmpty()) {

            System.out.println("No Books Issued.");
            return;
        }

        for (BookIssue issue : issuedBooks.values()) {

            issue.displayIssueDetails();
        }

    }

    // View Borrowed Books of a Student
    public void viewBorrowedBooks(String studentId) {

        ArrayList<Book> borrowed = borrowedBooks.get(studentId);

        if (borrowed == null || borrowed.isEmpty()) {

            System.out.println("No Borrowed Books.");
            return;
        }

        for (Book book : borrowed) {

            book.displayBook();
        }

    }

    // Fine Calculation
    public double calculateFine(int lateDays) {

        if (lateDays <= 0) {
            return 0;
        }

        return lateDays * 5;
    }

}