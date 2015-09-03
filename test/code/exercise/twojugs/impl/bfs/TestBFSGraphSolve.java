package code.exercise.twojugs.impl.bfs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.exercise.twojugs.solution.data.PouringSequence;
import code.exercise.twojugs.solution.impl.bfs.BFSGraphSolver;
import code.exercise.twojugs.solution.impl.bfs.DiscoverTwoJugStates;
import code.exercise.twojugs.solution.impl.bfs.TwoJugGoal;

public class TestBFSGraphSolve {

    private BFSGraphSolver<PouringSequence> solver;
    private PouringSequence initialState;
    private TwoJugGoal goal;
    private DiscoverTwoJugStates transition;

    @Before
    public void setUp() {
        solver = new BFSGraphSolver<PouringSequence>();

    }

    @After
    public void tearDown() {
        solver = null;
    }

    @Test
    public void solveValidProblem() throws Exception {

        initialState = new PouringSequence(0, 0, "Initial state");
        goal = new TwoJugGoal(2);
        transition = new DiscoverTwoJugStates(2, 3);

        List<PouringSequence> result = solver.searchForSolution(initialState,
                goal, transition);

        assertNotNull("should not be null", result);
        assertEquals("should be 2", 2, result.size());
    }

    @Test
    public void solveInvalidProblem() throws Exception {

        initialState = new PouringSequence(0, 0, "Initial state");
        goal = new TwoJugGoal(3);
        transition = new DiscoverTwoJugStates(4, 6);

        List<PouringSequence> result = solver.searchForSolution(initialState,
                goal, transition);

        assertNotNull("should not be null", result);
        assertEquals("should be 0", 0, result.size());
    }
}
