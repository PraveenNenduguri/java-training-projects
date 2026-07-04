package model;

public class BookIssue {

	private int issueId;
	private String studentId;
	private int bookId;
	private String issueDate;
	private String dueDate;
	private String returnDate;
	private double fine;

	// Default Constructor
	public BookIssue() {

	}

	// Parameterized Constructor

	public BookIssue(int issueId, String studentId, int bookId,
			String issueDate, String dueDate,
			String returnDate, double fine) {

		this.issueId = issueId;
		this.studentId = studentId;
		this.bookId = bookId;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.fine = fine;
	}

	// Getters and Setters

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	// Display Method

	public void displayIssueDetails() {

		System.out.println("--------------------------------");
		System.out.println("Issue ID     : " + issueId);
		System.out.println("Student ID   : " + studentId);
		System.out.println("Book ID      : " + bookId);
		System.out.println("Issue Date   : " + issueDate);
		System.out.println("Due Date     : " + dueDate);
		System.out.println("Return Date  : " + returnDate);
		System.out.println("Fine         : ₹" + fine);
	}

}