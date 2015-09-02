package code.exercise.twojugs.exception;
/**
 * Specifies TwoJugException
 * @author Saida Dhanavath
 *
 */
public class TwoJugException extends Exception {
	/** Serializable version Id. */
	private static final long serialVersionUID = 3058461674271119166L;

	public TwoJugException(String message) {
		super(message);
	}

	public TwoJugException(Throwable cause) {
		super(cause);

	}

	public TwoJugException(String message, Throwable cause) {
		super(message, cause);

	}

}
