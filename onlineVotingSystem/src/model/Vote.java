package model;

import java.io.Serializable;

public class Vote implements Serializable {

	private static final long serialVersionUID = 1L;

	private int voteId;
	private String studentUsername;
	private int candidateId;
	private String candidateName;

	// Default Constructor
	public Vote() {

	}

	// Parameterized Constructor
	public Vote(int voteId, String studentUsername, int candidateId, String candidateName) {

		this.voteId = voteId;
		this.studentUsername = studentUsername;
		this.candidateId = candidateId;
		this.candidateName = candidateName;
	}

	public int getVoteId() {
		return voteId;
	}

	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}

	public String getStudentUsername() {
		return studentUsername;
	}

	public void setStudentUsername(String studentUsername) {
		this.studentUsername = studentUsername;
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

	@Override
	public String toString() {

		return "\nVote ID         : " + voteId + "\nStudent Username: " + studentUsername
				+ "\nCandidate ID    : " + candidateId + "\nCandidate Name  : " + candidateName;
	}

}