package service;

import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import exception.CandidateNotFoundException;
import exception.DuplicateVoteException;
import model.Candidate;
import model.Student;
import model.Vote;

public class VotingService implements VotingOperations{

	private HashMap<String, Boolean> votingStatus = new HashMap<>();
	private ArrayList<Vote> voteHistory = new ArrayList<>();

	private Scanner sc = new Scanner(System.in);

	private StudentService studentService;
	private CandidateService candidateService;

	private static int voteCounter = 1;

	public VotingService(StudentService studentService,
			CandidateService candidateService) {

		this.studentService = studentService;
		this.candidateService = candidateService;

	}

	public HashMap<String, Boolean> getVotingStatus() {
		return votingStatus;
	}

	public ArrayList<Vote> getVoteHistory() {
		return voteHistory;
	}
	
	public void castVote() {

		try {

			Student student = studentService.getLoggedInStudent();

			if (student == null) {

				System.out.println("Please login first.");
				return;

			}

			String username = student.getUsername();

			if (votingStatus.getOrDefault(username, false)) {

				throw new DuplicateVoteException(
						"You have already cast your vote.");

			}

			candidateService.displayCandidates();

			System.out.print("\nEnter Candidate ID : ");
			int candidateId = sc.nextInt();
			sc.nextLine();

			Candidate candidate = candidateService.getCandidates().get(candidateId);

			if (candidate == null) {

				throw new CandidateNotFoundException(
						"Candidate not found.");

			}

			candidate.setVoteCount(candidate.getVoteCount() + 1);

			Vote vote = new Vote(voteCounter++, username,
					candidateId, candidate.getCandidateName());

			voteHistory.add(vote);

			votingStatus.put(username, true);

			System.out.println("Vote Cast Successfully.");

		}

		catch (DuplicateVoteException | CandidateNotFoundException e) {

			System.out.println(e.getMessage());

		}

	}
	
	public void viewVotingStatus() {

		Student student = studentService.getLoggedInStudent();

		if (student == null) {

			System.out.println("Please login first.");
			return;

		}

		String username = student.getUsername();

		if (votingStatus.getOrDefault(username, false)) {

			System.out.println("Status : Vote Cast Successfully.");

		}

		else {

			System.out.println("Status : Vote Not Cast.");

		}

	}
	
	public void saveElectionData() {

		try {

			ObjectOutputStream out =
					new ObjectOutputStream(
							new FileOutputStream("ElectionData.dat"));

			out.writeObject(studentService.getStudents());
			out.writeObject(candidateService.getCandidates());
			out.writeObject(votingStatus);
			out.writeObject(voteHistory);

			out.close();

			System.out.println("Election Data Saved Successfully.");

		}

		catch (IOException e) {

			System.out.println("Error : " + e.getMessage());

		}

	}
	
	@SuppressWarnings("unchecked")
	public void loadElectionData() {

		try {

			ObjectInputStream in =
					new ObjectInputStream(
							new FileInputStream("ElectionData.dat"));

			studentService.getStudents().clear();
			studentService.getStudents().putAll(
					(HashMap<String, Student>) in.readObject());

			candidateService.getCandidates().clear();
			candidateService.getCandidates().putAll(
					(HashMap<Integer, Candidate>) in.readObject());

			votingStatus.clear();
			votingStatus.putAll(
					(HashMap<String, Boolean>) in.readObject());

			voteHistory.clear();
			voteHistory.addAll(
					(ArrayList<Vote>) in.readObject());

			in.close();

			System.out.println("Election Data Loaded Successfully.");

		}

		catch (IOException | ClassNotFoundException e) {

			System.out.println("No Previous Records Found.");

		}

	}
	
}
