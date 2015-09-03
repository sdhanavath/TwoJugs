
package code.exercise.twojugs.solution;

import code.exercise.twojugs.solution.data.TwoJugResult;
import code.exercise.twojugs.solution.exception.TwoJugException;

public interface TwoJugSolution {

    /**
     * To verify that a solution exist for the given input values.
     */
    boolean isSolvable(int sizeOfFirstJug, int sizeOfSecondJug, int sizeToBeMeasured)
            throws TwoJugException;

    /**
     * The purpose of this method is compute the solution for two jug problem.
     * The solution is encapsulated within <code>TwoJugResult</code> object.
     * which has methods to generate details of the solution.
     * 
     */
    TwoJugResult getSolution(int sizeOfFirstJug, int sizeOfSecondJug, int sizeToBeMeasured)
            throws TwoJugException;

}
