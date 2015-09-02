package code.exercise.twojugs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import code.exercise.twojugs.exception.TwoJugBadArgException;
import code.exercise.twojugs.exception.TwoJugException;
import code.exercise.twojugs.exception.TwoJugProblemNotSolvableException;
import code.exercise.twojugs.util.TwoJugUtil;

/**
 * Abstract class for TwoJugProblem, to implement common behaviors across the
 * specific solution algorithm.
 * 
 * @author Saida Dhanavath
 * 
 */
public abstract class AbstractTwoJugProblem implements TwoJugProblem {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTwoJugProblem.class);

	@Override
	public boolean isSolvable(int sizeOfJugM, int sizeOfJugN, int sizeOfSolution)
			throws TwoJugException {
		LOGGER.debug("Checking if("+sizeOfJugM+","+sizeOfJugN+","+sizeOfSolution+") has a solution or not");

		// Make sure that the jugs can hold solution size
		if (sizeOfSolution > sizeOfJugM && sizeOfSolution > sizeOfJugN) {
			throw new TwoJugBadArgException(
					"Make sure that the solution size smaller than sizes of two jugs");
		}
		// Make sure that the jug sizes are positive and limited, solution sizes
		if (sizeOfJugM < 0 || sizeOfJugN < 0 || sizeOfSolution < 0) {
			throw new TwoJugBadArgException(
					"Make sure that the jug and solution sizes are positive");
		}
		// Quick test if left side sizes even and right side size odd, not
		// solvable
		if (sizeOfJugM % 2 == 0 && sizeOfJugN % 2 == 0
				&& sizeOfSolution % 2 != 0) {
			throw new TwoJugProblemNotSolvableException(
					"Make sure that when two jugs sizes are even solution size must also be even");
		}
		// sizeOfJugM=0: sizeOfJugN*y = sizeOfSolution : y =
		// sizeOfSolution/sizeOfJugN
		if (0 == sizeOfJugM
				&& ((0 == sizeOfJugN) || (sizeOfSolution % sizeOfJugN != 0))) {
			throw new TwoJugProblemNotSolvableException(
					"This problem is not solvable");
		}
		// sizeOfJugN=0: sizeOfJugM*y = sizeOfSolution : y =
		// sizeOfSolution/sizeOfJugM
		if (0 == sizeOfJugN
				&& ((0 == sizeOfJugM) || (sizeOfSolution % sizeOfJugM != 0))) {
			throw new TwoJugProblemNotSolvableException(
					"This poblem is not solvable");
		}
		// Jug sizes always positive
		int gcd = TwoJugUtil.gcd(sizeOfJugM, sizeOfJugN);
		if (sizeOfSolution % gcd != 0) {
			throw new TwoJugProblemNotSolvableException(
					"This problem is not solvable");
		}
		LOGGER.debug("Found that ("+sizeOfJugM+","+sizeOfJugN+","+sizeOfSolution+") has a solution");
		return true;
	}

}
