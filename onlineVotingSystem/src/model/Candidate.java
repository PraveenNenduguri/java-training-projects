package model;

import java.io.Serializable;

public class Candidate implements Serializable {

	private static final long serialVersionUID = 1L;

	private int candidateId;
	private String candidateName;
	private String department;
	private int year;
	private String symbol;
	private int voteCount;

	// Default Constructor
	public Candidate() {

	}

	// Parameterized Constructor
	public Candidate(int candidateId, String candidateName, String department, int year, String symbol) {

		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.department = department;
		this.year = year;
		this.symbol = symbol;
		this.voteCount = 0;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
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

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	@Override
	public String toString() {

		return "\nCandidate ID    : " + candidateId + "\nCandidate Name  : " + candidateName + "\nDepartment      : "
				+ department + "\nYear            : " + year + "\nSymbol          : " + symbol
				+ "\nVotes           : " + voteCount;
	}

}