package rnd.saida.twojugs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rnd.saida.twojugs.data.TwoJugResult;
import rnd.saida.twojugs.exception.TwoJugException;
import rnd.saida.twojugs.exception.TwoJugProblemNotSolvableException;
import rnd.saida.twojugs.impl.bfs.BFSTwoJugProblem;


/**
 * 
 * @author Saida Dhanavath
 * 
 */
public class TwoJugProblemTest {

	private TwoJugProblem twoJugProblem;

	@Before
	public void setUp() {
		twoJugProblem = new BFSTwoJugProblem();
	}

	@After
	public void tearDown() {
		twoJugProblem = null;
	}

	@Test
	public void isSolvableValid() {
		// valid case
		assertTrue("should be true", twoJugProblem.isSolvable(4, 5, 3));

		// another valid with easy initial condition
		assertTrue("should be true", twoJugProblem.isSolvable(4, 5, 0));
	}

	@Test
	public void isSolvableInvalidJugs() {
		// invalid case even jug odd solution
		assertFalse("should be false", twoJugProblem.isSolvable(4, 6, 3));

		// another invalid can not fill jugs
		assertFalse("should be false", twoJugProblem.isSolvable(0, 0, 1));
	}

	@Test
	public void isSolvableInvalidDivisor() {
		// invalid GCD not divisor to solution size
		assertFalse("should be false", twoJugProblem.isSolvable(3, 9, 2));

	}

	@Test(expected = TwoJugProblemNotSolvableException.class)
	public void isNotSolvable() throws TwoJugException {
		twoJugProblem.getSolution(4, 6, 3);
	}

	@Test(expected = TwoJugProblemNotSolvableException.class)
	public void isNotSolvableEdgeCase() throws TwoJugException {
		twoJugProblem.getSolution(0, 0, 1);
	}

	@Test
	public void solveBasic() throws TwoJugException {
		TwoJugResult result = twoJugProblem.getSolution(3, 5, 4);
		assertEquals("Pouring sequence size should be equal",
				result.getPouringSequenceSize(), 7);
		assertEquals("Pouring sequence path size should equal",
				result.numberOfPouringSteps(), 6);
	}

	@Test
	public void solveAnotherBasic() throws TwoJugException {
		TwoJugResult result = twoJugProblem.getSolution(3, 7, 2);
		assertEquals("Pouring sequence size should be equal",
				result.getPouringSequenceSize(), 7);
		assertEquals("Pouring sequence path size should equal",
				result.numberOfPouringSteps(), 6);
	}

	@Test
	public void solveTrivial() throws TwoJugException {
		TwoJugResult result = twoJugProblem.getSolution(5, 3, 0);
		assertEquals("path size should equal", result.getPouringSequenceSize(), 1);
	}
}
