package service;

import java.util.HashMap;
import java.util.Scanner;

import exception.StudentNotFoundException;
import interfaces.StudentOperations;
import model.Book;
import model.Student;

public class StudentService implements StudentOperations {

	Scanner sc = new Scanner(System.in);

	private HashMap<String, Student> students = new HashMap<>();

	private BookService bookService;
	private IssueService issueService;

	// Stores the currently logged-in student
	private String currentStudentId;

	// Constructor
	public StudentService(BookService bookService, IssueService issueService) {

		this.bookService = bookService;
		this.issueService = issueService;
	}

	// Register Student
	@Override
	public void register() {

		System.out.print("Enter Student ID : ");
		String studentId = sc.next();

		if (students.containsKey(studentId)) {
			System.out.println("Student ID already exists.");
			return;
		}

		sc.nextLine();

		System.out.print("Enter Student Name : ");
		String name = sc.nextLine();

		System.out.print("Enter Password : ");
		String password = sc.nextLine();

		System.out.print("Enter Department : ");
		String department = sc.nextLine();

		Student student = new Student(studentId, name, password, department);

		students.put(studentId, student);

		System.out.println("Student Registered Successfully.");
	}

	// Login
	@Override
	public void login() {

		try {

			System.out.print("Enter Student ID : ");
			String studentId = sc.next();

			System.out.print("Enter Password : ");
			String password = sc.next();

			if (!students.containsKey(studentId)) {
				throw new StudentNotFoundException("Student Not Found.");
			}

			Student student = students.get(studentId);

			if (student.getPassword().equals(password)) {

				currentStudentId = studentId;
				System.out.println("Login Successful.");

			} else {

				System.out.println("Invalid Password.");
			}

		} catch (StudentNotFoundException e) {

			System.out.println(e.getMessage());

		}

	}

	// Search Book
	@Override
	public void searchBooks() {

		System.out.print("Enter Book ID : ");
		int id = sc.nextInt();

		for (Book book : bookService.getBooks()) {

			if (book.getBookId() == id) {

				book.displayBook();
				return;
			}
		}

		System.out.println("Book Not Found.");
	}

	// Issue Book
	@Override
	public void issueBook() {

		if (currentStudentId == null) {

			System.out.println("Please login first.");
			return;
		}

		issueService.issueBook(currentStudentId);
	}

	// Return Book
	@Override
	public void returnBook() {

		if (currentStudentId == null) {

			System.out.println("Please login first.");
			return;
		}

		issueService.returnBook(currentStudentId);
	}

	// Renew Book
	@Override
	public void renewBook() {

		if (currentStudentId == null) {

			System.out.println("Please login first.");
			return;
		}

		issueService.renewBook();
	}

	// Logout
	public void logout() {

		currentStudentId = null;
		System.out.println("Logged Out Successfully.");
	}

	// Getter
	public HashMap<String, Student> getStudents() {

		return students;
	}
}