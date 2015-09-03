package code.exercise.twojugs.solution.solution.common;

public enum TwoJugConstant {

    TOBEMEASUREDMUSTBELESS(
            "sizeToBeMeasured must be lesser or equal to the sizes of jugs"), THECOMPUTEDSOLUTIONIS(
            "The Computed solution is"),

    TECHNICALEXCEPTION(
            "echnical Exception occured while computing the solution."),

    SEARCHINGFORSOLUTION("Searching for solution"),
    YES("Y");

    private String message;

    private TwoJugConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
