package rnd.saida.twojugs.exception;
/**
 * Signals that the Two Jug problem is not solvable.
 * @author Saida Dhanavath
 *
 */
public class TwoJugProblemNotSolvableException extends TwoJugException {
	/** Serializable version Id. */
	private static final long serialVersionUID = -8241203325955565009L;

	public TwoJugProblemNotSolvableException(String message) {
		super(message);
	}

}
