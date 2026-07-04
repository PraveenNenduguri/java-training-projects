package service;

import java.util.HashMap;

import java.util.Scanner;

import exception.CandidateNotFoundException;
import model.Candidate;

public class CandidateService implements CandidateOperations{

	private HashMap<Integer, Candidate> candidates = new HashMap<>();

	private Scanner sc = new Scanner(System.in);

	private static int candidateCounter = 101;

	public HashMap<Integer, Candidate> getCandidates() {
		return candidates;
	}
	
	public void addCandidate() {

		System.out.println("\n===== Add Candidate =====");

		int candidateId = candidateCounter++;

		System.out.print("Enter Candidate Name : ");
		String name = sc.nextLine();

		System.out.print("Enter Department : ");
		String department = sc.nextLine();

		System.out.print("Enter Year : ");
		int year = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Symbol : ");
		String symbol = sc.nextLine();

		Candidate candidate = new Candidate(candidateId, name,
				department, year, symbol);

		candidates.put(candidateId, candidate);

		System.out.println("Candidate Added Successfully.");
		System.out.println("Candidate ID : " + candidateId);

	}
	
	public void updateCandidate() {

		try {

			System.out.print("Enter Candidate ID : ");
			int id = sc.nextInt();
			sc.nextLine();

			Candidate candidate = candidates.get(id);

			if (candidate == null) {

				throw new CandidateNotFoundException("Candidate Not Found.");

			}

			System.out.print("Enter New Name : ");
			candidate.setCandidateName(sc.nextLine());

			System.out.print("Enter New Department : ");
			candidate.setDepartment(sc.nextLine());

			System.out.print("Enter New Year : ");
			candidate.setYear(sc.nextInt());
			sc.nextLine();

			System.out.print("Enter New Symbol : ");
			candidate.setSymbol(sc.nextLine());

			System.out.println("Candidate Updated Successfully.");

		}

		catch (CandidateNotFoundException e) {

			System.out.println(e.getMessage());

		}

	}
	public void removeCandidate() {

		try {

			System.out.print("Enter Candidate ID : ");
			int id = sc.nextInt();
			sc.nextLine();

			if (!candidates.containsKey(id)) {

				throw new CandidateNotFoundException("Candidate Not Found.");

			}

			candidates.remove(id);

			System.out.println("Candidate Removed Successfully.");

		}

		catch (CandidateNotFoundException e) {

			System.out.println(e.getMessage());

		}

	}
	public void displayCandidates() {

		if (candidates.isEmpty()) {

			System.out.println("No Candidates Available.");
			return;

		}

		System.out.println("\n===== Candidate List =====");

		for (Candidate candidate : candidates.values()) {

			System.out.println(candidate);
			System.out.println("---------------------------");

		}

	}
	
	public void searchCandidate() {

		try {

			System.out.print("Enter Candidate ID : ");
			int id = sc.nextInt();
			sc.nextLine();

			Candidate candidate = candidates.get(id);

			if (candidate == null) {

				throw new CandidateNotFoundException("Candidate Not Found.");

			}

			System.out.println(candidate);

		}

		catch (CandidateNotFoundException e) {

			System.out.println(e.getMessage());

		}

	}
	
}