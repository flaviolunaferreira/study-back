package the.coyote.learn.Exceptions;

public class IntegratyViolation extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public IntegratyViolation(String message, Throwable cause) {
		super(message, cause);
	}

	public IntegratyViolation(String message) {
		super(message);
	}
}
