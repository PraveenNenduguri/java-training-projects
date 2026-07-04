package main;

import java.util.Scanner;

import service.BookService;
import service.IssueService;
import service.StudentService;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookService bookService = new BookService();
        IssueService issueService = new IssueService(bookService);
        StudentService studentService = new StudentService(bookService, issueService);

        int mainChoice;

        do {

            System.out.println("\n========== LIBRARY MANAGEMENT SYSTEM ==========");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            mainChoice = sc.nextInt();

            switch (mainChoice) {

                case 1:

                    adminMenu(sc, bookService);
                    break;

                case 2:

                    studentMenu(sc, studentService);
                    break;

                case 3:

                    System.out.println("Thank You!");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (mainChoice != 3);

        sc.close();
    }

    // Admin Menu
    public static void adminMenu(Scanner sc, BookService bookService) {

        int choice;

        do {

            System.out.println("\n------ ADMIN MENU ------");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Search Book");
            System.out.println("5. View All Books");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    bookService.addBook();
                    break;

                case 2:
                    bookService.updateBook();
                    break;

                case 3:
                    bookService.deleteBook();
                    break;

                case 4:
                    bookService.searchBook();
                    break;

                case 5:
                    bookService.viewAllBooks();
                    break;

                case 6:
                    System.out.println("Logged Out Successfully.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

    }

    // Student Menu
    public static void studentMenu(Scanner sc, StudentService studentService) {

        int choice;

        do {

            System.out.println("\n------ STUDENT MENU ------");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Search Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Renew Book");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    studentService.register();
                    break;

                case 2:
                    studentService.login();
                    break;

                case 3:
                    studentService.searchBooks();
                    break;

                case 4:
                    studentService.issueBook();
                    break;

                case 5:
                    studentService.returnBook();
                    break;

                case 6:
                    studentService.renewBook();
                    break;

                case 7:
                    System.out.println("Logged Out Successfully.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

    }
}