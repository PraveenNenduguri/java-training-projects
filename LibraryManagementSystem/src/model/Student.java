package model;

public class Student {

	private String studentId;
	private String name;
	private String password;
	private String department;

	// Default Constructor
	public Student() {

	}

	// Parameterized Constructor
	public Student(String studentId, String name,
			String password, String department) {

		this.studentId = studentId;
		this.name = name;
		this.password = password;
		this.department = department;
	}

	// Getters and Setters

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	// Display Method

	public void displayStudent() {

		System.out.println("----------------------------");
		System.out.println("Student ID : " + studentId);
		System.out.println("Name       : " + name);
		System.out.println("Department : " + department);
	}

}