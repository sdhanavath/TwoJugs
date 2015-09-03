package code.exercise.twojugs.solution.exception;

public class TwoJugException extends Exception {
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
