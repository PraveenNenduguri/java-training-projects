
package main;

import java.util.Scanner;

import service.CandidateService;
import service.StudentService;
import service.VotingService;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		StudentService studentService = new StudentService();
		CandidateService candidateService = new CandidateService();
		VotingService votingService = new VotingService(studentService, candidateService);

		int choice;

		do {

			System.out.println("\n==========================================");
			System.out.println("      ONLINE VOTING SYSTEM");
			System.out.println("==========================================");

			System.out.println("1. Student Registration");
			System.out.println("2. Student Login");
			System.out.println("3. View Profile");
			System.out.println("4. Change Password");
			System.out.println("5. Forgot Password");

			System.out.println();

			System.out.println("6. Add Candidate");
			System.out.println("7. Update Candidate");
			System.out.println("8. Remove Candidate");
			System.out.println("9. Display Candidate List");
			System.out.println("10. Search Candidate");

			System.out.println();

			System.out.println("11. Cast Vote");
			System.out.println("12. View Voting Status");

			System.out.println();

			System.out.println("13. Save Election Data");
			System.out.println("14. Load Election Data");

			System.out.println();

			System.out.println("15. Exit");

			System.out.print("\nEnter Your Choice : ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				studentService.registerStudent();
				break;

			case 2:
				studentService.login();
				break;

			case 3:
				studentService.viewProfile();
				break;

			case 4:
				studentService.changePassword();
				break;

			case 5:
				studentService.forgotPassword();
				break;

			case 6:
				candidateService.addCandidate();
				break;

			case 7:
				candidateService.updateCandidate();
				break;

			case 8:
				candidateService.removeCandidate();
				break;

			case 9:
				candidateService.displayCandidates();
				break;

			case 10:
				candidateService.searchCandidate();
				break;

			case 11:
				votingService.castVote();
				break;

			case 12:
				votingService.viewVotingStatus();
				break;

			case 13:
				votingService.saveElectionData();
				break;

			case 14:
				votingService.loadElectionData();
				break;

			case 15:
				System.out.println("\nThank You for Using Online Voting System.");
				break;

			default:
				System.out.println("Invalid Choice.");
			}

		} while (choice != 15);

		sc.close();
	}
}