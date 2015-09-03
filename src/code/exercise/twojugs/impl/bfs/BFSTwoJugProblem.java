package code.exercise.twojugs.impl.bfs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import code.exercise.twojugs.AbstractTwoJugProblem;
import code.exercise.twojugs.data.PouringSequence;
import code.exercise.twojugs.data.TwoJugResult;
import code.exercise.twojugs.exception.TwoJugException;
import code.exercise.twojugs.exception.TwoJugProblemNotSolvableException;
import code.exercise.twojugs.exception.TwoJugTechnicalException;

/**
 * BFS - Breadth First Search implementation for two jug problem
 * 
 * @author Saida Dhanavath
 * 
 */
public class BFSTwoJugProblem extends AbstractTwoJugProblem {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(BFSTwoJugProblem.class);

	@Override
	public TwoJugResult getSolution(int sizeOfJugM, int sizeOfJugN,
			int sizeOfSolution) throws TwoJugException {
		LOGGER.info("Checking whether it has solution.... for (" + sizeOfJugM
				+ "," + sizeOfJugN + "," + sizeOfSolution + ")");
		if (!isSolvable(sizeOfJugM, sizeOfJugN, sizeOfSolution)) {
			throw new TwoJugProblemNotSolvableException(
					"Problem is not solvable");
		}
		LOGGER.info("Yes, It has a soltion, Starting to compute the solution");

		BFSGraphSolver<PouringSequence> solver = new BFSGraphSolver<PouringSequence>();

		List<PouringSequence> solution = solver.searchForSolution(
				new PouringSequence(0, 0, "Initial state"), new TwoJugGoal(
						sizeOfSolution), new DiscoverTwoJugStates(sizeOfJugM,
						sizeOfJugN));

		LOGGER.debug("The Computed solution is" + solution);

		if (null == solution || solution.isEmpty()) {
			throw new TwoJugTechnicalException(
					"Technical Exception occured while computing the solution. ");
		}
		return new TwoJugResult(solution);
	}
}
