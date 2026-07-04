package model;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private int studentId;
	private String name;
	private String department;
	private int year;
	private String username;
	private String password;
	private String securityQuestion;
	private String securityAnswer;

	// Default Constructor
	public Student() {

	}

	// Parameterized Constructor
	public Student(int studentId, String name, String department, int year, String username, String password,
			String securityQuestion, String securityAnswer) {

		this.studentId = studentId;
		this.name = name;
		this.department = department;
		this.year = year;
		this.username = username;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	@Override
	public String toString() {

		return "\nStudent ID      : " + studentId + "\nName            : " + name + "\nDepartment      : "
				+ department + "\nYear            : " + year + "\nUsername        : " + username;
	}

}