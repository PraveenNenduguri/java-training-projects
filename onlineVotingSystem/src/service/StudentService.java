package service;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

import exception.InvalidLoginException;
import exception.InvalidPasswordException;
import model.Student;

public class StudentService implements StudentOperations {

	private HashMap<String, Student> students = new HashMap<>();
	private Scanner sc = new Scanner(System.in);

	private Student loggedInStudent = null;

	private static int studentCounter = 1001;

	// Getter method for students
	public HashMap<String, Student> getStudents() {
		return students;
	}

	// Getter method for logged in student
	public Student getLoggedInStudent() {
		return loggedInStudent;
	}


	public void registerStudent() {

		System.out.println("\n===== Student Registration =====");

		int studentId = studentCounter++;

		System.out.print("Enter Student Name : ");
		String name = sc.nextLine();

		System.out.print("Enter Department : ");
		String department = sc.nextLine();

		System.out.print("Enter Year : ");
		int year = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Username : ");
		String username = sc.nextLine();

		if (students.containsKey(username)) {

			System.out.println("Username already exists.");
			return;
		}

		String password = "";

		while (true) {

			try {

				System.out.print("Enter Password : ");
				password = sc.nextLine();

				validatePassword(password);

				break;

			} catch (InvalidPasswordException e) {

				System.out.println(e.getMessage());

			}

		}

		System.out.print("Enter Security Question : ");
		String question = sc.nextLine();

		System.out.print("Enter Security Answer : ");
		String answer = sc.nextLine();

		Student student = new Student(studentId, name, department, year,
				username, password, question, answer);

		students.put(username, student);

		System.out.println("\nStudent Registered Successfully.");
		System.out.println("Student ID : " + studentId);

	}

	public void login() {

		try {

			System.out.println("\n===== Student Login =====");

			System.out.print("Enter Username : ");
			String username = sc.nextLine();

			System.out.print("Enter Password : ");
			String password = sc.nextLine();

			Student student = students.get(username);

			if (student == null) {

				throw new InvalidLoginException("Invalid Username.");

			}

			if (!student.getPassword().equals(password)) {

				throw new InvalidLoginException("Invalid Password.");

			}

			loggedInStudent = student;

			System.out.println("Login Successful.");

		}

		catch (InvalidLoginException e) {

			System.out.println(e.getMessage());

		}

	}

	private void validatePassword(String password)
			throws InvalidPasswordException {

		String regex =
				"^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";

		if (!Pattern.matches(regex, password)) {

			throw new InvalidPasswordException(

					"Password must contain:\n"
							+ "Minimum 8 characters\n"
							+ "One uppercase letter\n"
							+ "One lowercase letter\n"
							+ "One digit\n"
							+ "One special character");

		}

	}



	public void viewProfile() {

		if (loggedInStudent == null) {

			System.out.println("Please login first.");
			return;
		}

		System.out.println("\n===== Student Profile =====");
		System.out.println(loggedInStudent);

	}

	public void changePassword() {

		if (loggedInStudent == null) {

			System.out.println("Please login first.");
			return;

		}

		try {

			System.out.print("Enter Current Password : ");
			String currentPassword = sc.nextLine();

			if (!loggedInStudent.getPassword().equals(currentPassword)) {

				throw new InvalidPasswordException("Current password is incorrect.");

			}

			String newPassword;

			while (true) {

				try {

					System.out.print("Enter New Password : ");
					newPassword = sc.nextLine();

					validatePassword(newPassword);

					break;

				} catch (InvalidPasswordException e) {

					System.out.println(e.getMessage());

				}

			}

			loggedInStudent.setPassword(newPassword);

			System.out.println("Password Changed Successfully.");

		}

		catch (InvalidPasswordException e) {

			System.out.println(e.getMessage());

		}

	}

	public void forgotPassword() {

		try {

			System.out.print("Enter Username : ");
			String username = sc.nextLine();

			Student student = students.get(username);

			if (student == null) {

				throw new InvalidLoginException("Username does not exist.");

			}

			System.out.println("Security Question : "
					+ student.getSecurityQuestion());

			System.out.print("Enter Security Answer : ");
			String answer = sc.nextLine();

			if (!student.getSecurityAnswer().equalsIgnoreCase(answer)) {

				System.out.println("Incorrect Security Answer.");
				return;

			}

			String newPassword;

			while (true) {

				try {

					System.out.print("Enter New Password : ");
					newPassword = sc.nextLine();

					validatePassword(newPassword);

					break;

				} catch (InvalidPasswordException e) {

					System.out.println(e.getMessage());

				}

			}

			student.setPassword(newPassword);

			System.out.println("Password Reset Successfully.");

		}

		catch (InvalidLoginException e) {

			System.out.println(e.getMessage());

		}

	}
}