package code.exercise.twojugs.impl.bfs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.exercise.twojugs.data.TwoJugResult;
import code.exercise.twojugs.exception.TwoJugBadArgException;
import code.exercise.twojugs.exception.TwoJugException;
import code.exercise.twojugs.exception.TwoJugProblemNotSolvableException;

/**
 * 
 * @author Saida Dhanavath
 * 
 */
public class TestBFSTwoJugProblem {

	private BFSTwoJugProblem twoJugProblem;

	@Before
	public void setUp() {
		twoJugProblem = new BFSTwoJugProblem();
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

	@Test(expected = TwoJugProblemNotSolvableException.class)
	public void isNotSolvable() throws TwoJugException {
		twoJugProblem.getSolution(4, 6, 3);
	}

	@Test(expected = TwoJugBadArgException.class)
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
