package code.exercise.twojugs.solution;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import code.exercise.twojugs.solution.exception.TwoJugException;
import code.exercise.twojugs.solution.exception.TwoJugProblemNotSolvableException;
import code.exercise.twojugs.solution.solution.common.InputValidator;

public abstract class AbstractTwoJugSolution implements TwoJugSolution {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(AbstractTwoJugSolution.class);

    @Override
    public boolean isSolvable(int sizeOfFirstJug, int sizeOfSecondJug,
            int sizeToBeMeasured) throws TwoJugException {
        LOGGER.debug("Checking if(" + sizeOfFirstJug + "," + sizeOfSecondJug
                + "," + sizeToBeMeasured + ") has a solution or not");
        if(!InputValidator.validate(sizeOfFirstJug, sizeOfSecondJug, sizeToBeMeasured))
            throw new TwoJugException("Invalid inputs");
        int gcd = BigInteger.valueOf(sizeOfFirstJug)
                .gcd(BigInteger.valueOf(sizeOfSecondJug)).intValue();

        if (sizeToBeMeasured % gcd != 0) {
            throw new TwoJugProblemNotSolvableException(
                    "This problem is not solvable");
        }
        LOGGER.debug("Found that (" + sizeOfFirstJug + "," + sizeOfSecondJug
                + "," + sizeToBeMeasured + ") has a solution");
        return true;
    }

}
