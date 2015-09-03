package code.exercise.twojugs.solution.impl.bfs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import code.exercise.twojugs.solution.AbstractTwoJugSolution;
import code.exercise.twojugs.solution.data.PouringSequence;
import code.exercise.twojugs.solution.data.TwoJugResult;
import code.exercise.twojugs.solution.exception.TwoJugException;
import code.exercise.twojugs.solution.exception.TwoJugProblemNotSolvableException;
import code.exercise.twojugs.solution.exception.TwoJugTechnicalException;
import code.exercise.twojugs.solution.solution.common.TwoJugConstant;

/**
 * BFS - Breadth First Search implementation for two jug problem
 * 
 * @author Saida Dhanavath
 * 
 */
public class BFSTwoJugSolution extends AbstractTwoJugSolution {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(BFSTwoJugSolution.class);

    @Override
    public TwoJugResult getSolution(int sizeOfFirstJug, int sizeOfSecondJug,
            int sizeToBeMeasured) throws TwoJugException {
        LOGGER.info("Checking whether it has solution.... for ("
                + sizeOfFirstJug + "," + sizeOfSecondJug + ","
                + sizeToBeMeasured + ")");
        if (!isSolvable(sizeOfFirstJug, sizeOfSecondJug, sizeToBeMeasured)) {
            throw new TwoJugProblemNotSolvableException(
                    "Problem is not solvable");
        }
        LOGGER.info("Yes, It has a soltion, Starting to compute the solution");

        BFSGraphSolver<PouringSequence> solver = new BFSGraphSolver<PouringSequence>();
        PouringSequence root = new PouringSequence(0, 0, "Initial state");
        TwoJugGoal goal = new TwoJugGoal(sizeToBeMeasured);
        DiscoverTwoJugStates jugStates = new DiscoverTwoJugStates(
                sizeOfFirstJug, sizeOfSecondJug);

        List<PouringSequence> solution = solver.searchForSolution(root, goal,
                jugStates);

        LOGGER.debug(TwoJugConstant.TheComputedSolutionIs.getMessage()
                + solution);

        if (null == solution || solution.isEmpty()) {
            throw new TwoJugTechnicalException(
                    TwoJugConstant.TechnicalExceptionOccured.getMessage());
        }
        return new TwoJugResult(solution);
    }
}
