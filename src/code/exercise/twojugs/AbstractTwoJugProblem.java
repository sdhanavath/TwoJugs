package code.exercise.twojugs;

import code.exercise.twojugs.TwoJugProblem;
import code.exercise.twojugs.util.TwoJugUtil;

public abstract class AbstractTwoJugProblem implements TwoJugProblem{

	public boolean isSolvable(int sizeOfJugM, int sizeOfJugN, int sizeOfSolution) {

		// Make sure that the jugs can hold solution size
		if (sizeOfSolution > sizeOfJugM && sizeOfSolution > sizeOfJugN) {
			return false;
		}
		// positive and limited jug, solution sizes
		if (sizeOfJugM < 0 || sizeOfJugN < 0 || sizeOfSolution < 0) {
			return false;
		}
		// Quick test if left side sizes even and right side size odd, not
		// solvable
		if (sizeOfJugM % 2 == 0 && sizeOfJugN % 2 == 0
				&& sizeOfSolution % 2 != 0) {
			return false;
		}
		// sizeOfJugM=0: sizeOfJugN*y = sizeOfSolution : y =
		// sizeOfSolution/sizeOfJugN
		if (0 == sizeOfJugM
				&& ((0 == sizeOfJugN) || (sizeOfSolution % sizeOfJugN != 0))) {
			return false;
		}
		// sizeOfJugN=0: sizeOfJugM*y = sizeOfSolution : y =
		// sizeOfSolution/sizeOfJugM
		if (0 == sizeOfJugN
				&& ((0 == sizeOfJugM) || (sizeOfSolution % sizeOfJugM != 0))) {
			return false;
		}
		// Jug sizes always positive
		int gcd = TwoJugUtil.gcd(sizeOfJugM, sizeOfJugN);
		if (sizeOfSolution % gcd != 0) {
			return false;
		}
		return true;
	}
	
}
