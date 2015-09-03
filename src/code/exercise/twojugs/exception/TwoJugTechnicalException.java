package code.exercise.twojugs.exception;

/**
 * Signals that the input parameters supplied are bad.
 * 
 * @author Saida Dhanavath
 * 
 */
public class TwoJugTechnicalException extends TwoJugException {
	/**
	 * serial version id
	 */
	private static final long serialVersionUID = 5101518929320462581L;

	public TwoJugTechnicalException(String message) {
		super(message);
	}
}
