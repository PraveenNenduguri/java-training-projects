package exception;

public class CandidateNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public CandidateNotFoundException() {
		super();
	}

	public CandidateNotFoundException(String message) {
		super(message);
	}
}