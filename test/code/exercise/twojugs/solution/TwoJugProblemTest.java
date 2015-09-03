package code.exercise.twojugs.solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.exercise.twojugs.solution.data.TwoJugResult;
import code.exercise.twojugs.solution.exception.TwoJugException;
import code.exercise.twojugs.solution.impl.bfs.BFSTwoJugSolution;

public class TwoJugProblemTest {

    private TwoJugSolution twoJugProblem;

    @Before
    public void setUp() {
        twoJugProblem = new BFSTwoJugSolution();
    }

    @After
    public void tearDown() {
        twoJugProblem = null;
    }

    @Test
    public void isSolvableValid() throws Exception {
        // valid case
        assertTrue("should be true", twoJugProblem.isSolvable(4, 5, 3));

        // another valid with easy initial condition
        assertTrue("should be true", twoJugProblem.isSolvable(4, 5, 0));
    }

    @Test
    public void inValidSizes() throws Exception {
        assertTrue(twoJugProblem.isSolvable(1, 0, 0));
    }

    @Test(expected = TwoJugException.class)
    public void isSolvableInvalidJugs() throws Exception {
        // invalid case even jug odd solution
        assertFalse("should be false", twoJugProblem.isSolvable(4, 6, 3));

        // another invalid can not fill jugs
        assertFalse("should be false", twoJugProblem.isSolvable(0, 0, 1));
    }

    @Test(expected = TwoJugException.class)
    public void isSolvableInvalidDivisor() throws Exception {
        // invalid GCD not divisor to solution size
        assertFalse("should be false", twoJugProblem.isSolvable(3, 9, 2));

    }

    @Test(expected = TwoJugException.class)
    public void isNotSolvable() throws TwoJugException {
        twoJugProblem.getSolution(4, 6, 3);
    }

    @Test(expected = Exception.class)
    public void isNotSolvableEdgeCase() throws TwoJugException {
        twoJugProblem.getSolution(0, 0, 1);
    }

    @Test
    public void solveBasic() throws TwoJugException {
        TwoJugResult result = twoJugProblem.getSolution(3, 5, 4);
        assertEquals("Pouring sequence path size should equal",
                result.numberOfPouringSteps(), 6);
    }

    @Test
    public void solveAnotherBasic() throws TwoJugException {
        TwoJugResult result = twoJugProblem.getSolution(3, 7, 2);
        assertEquals("Pouring sequence path size should equal",
                result.numberOfPouringSteps(), 6);
    }

    @Test
    public void solveTrivial() throws TwoJugException {
        TwoJugResult result = twoJugProblem.getSolution(5, 3, 0);
        assertEquals("path size should equal", result.numberOfPouringSteps(), 0);
    }
}
