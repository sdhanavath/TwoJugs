package code.exercise.twojugs.impl.bfs;

import code.exercise.twojugs.data.PouringSequence;

/**
 * Implementation of the Goal interface; used to identify when goal state is
 * reached
 * 
 * @author Saida Dhanavath
 * 
 */
public class TwoJugGoal implements Goal<PouringSequence> {
	int sizeOfSolution;

	public TwoJugGoal(int sizeOfSolution) {
		this.sizeOfSolution = sizeOfSolution;
	}

	@Override
	public boolean isGoal(PouringSequence sequence) {
		if (sequence.getSizeOfJugM() == sizeOfSolution
				|| sequence.getSizeOfJugN() == sizeOfSolution) {
			return true;
		}
		return false;
	}

}
