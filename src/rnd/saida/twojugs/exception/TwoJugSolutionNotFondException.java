package rnd.saida.twojugs.exception;

/**
 * Signals that there no two jug solution found.
 * 
 * @author Saida Dhanavath
 * 
 */
public class TwoJugSolutionNotFondException extends TwoJugException {
	/** Serializable version Id. */
	private static final long serialVersionUID = -7026611539570829033L;

	public TwoJugSolutionNotFondException(String message) {
		super(message);
	}

}
