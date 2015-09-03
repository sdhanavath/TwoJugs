package code.exercise.twojugs.solution.solution.common;

public enum TwoJugConstant {

    sizeToBeMeasuredMustBeLess(
            "sizeToBeMeasured must be lesser or equal to the sizes of jugs"),
            TheComputedSolutionIs("The Computed solution is"),
            
           TechnicalExceptionOccured ("echnical Exception occured while computing the solution."),
           
              SearchingForSolution("Searching for solution");

    private String message;

    private TwoJugConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
