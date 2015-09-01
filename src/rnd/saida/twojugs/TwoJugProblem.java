/**
 * 
 */
package rnd.saida.twojugs;

import rnd.saida.twojugs.data.TwoJugResult;
import rnd.saida.twojugs.exception.TwoJugException;

/**
 * Specifies API's for two jug problem
 * 
 * @author Saida Dhanavath
 * 
 */
public interface TwoJugProblem {

	/**
	 * <p>
	 * To verify that a solution exist for the given problem. Return true if a
	 * solution exists; otherwise, false. The two jug problem can be modelled by
	 * the Diophantine equation Mx + Ny = d, whose solvability is determined by
	 * the well known theorem GCD(Greatest Common Divisor) in Number Theory. <br>
	 * Where,<br>
	 * M, N are size of unmarkable jars,<br>
	 * d is the solution size to measure.<br>
	 * x,y are number of subtractions/additions (or) fill/unfill jars.<br>
	 * This equation may have many solutions or no solution at all.<br>
	 * 
	 * @param sizeOfJugM
	 *            - size of Jar M
	 * @param sizeOfJugN
	 *            - size of Jar N
	 * @param sizeOfSolution
	 *            - size to be measured.
	 * @return true if solution exists; otherwise, false,
	 */
	boolean isSolvable(int sizeOfJugM, int sizeOfJugN, int sizeOfSolution);

	/**
	 * The purpose of this method is compute the solution for two jug problem.
	 * The solution is encapsulated within <code>TwoJugResult</code> object.
	 * which has methods to generate details of the solution.
	 * 
	 * @param sizeOfJugM
	 *            - size of jar M.
	 * @param sizeOfJugN
	 *            - size of jar N.
	 * @param sizeOfSolution
	 *            - size to be measured.
	 * @return - twoJugResult
	 * @throws TwoJugException
	 *             - In case of any exception
	 */
	TwoJugResult getSolution(int sizeOfJugM, int sizeOfJugN, int sizeOfSolution)
			throws TwoJugException;

}
