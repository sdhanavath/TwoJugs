package code.exercise.twojugs.impl.bfs;

import java.util.ArrayList;
import java.util.List;

import code.exercise.twojugs.AbstractTwoJugProblem;
import code.exercise.twojugs.data.PouringSequence;
import code.exercise.twojugs.data.TwoJugResult;
import code.exercise.twojugs.exception.TwoJugException;
import code.exercise.twojugs.exception.TwoJugProblemNotSolvableException;
import code.exercise.twojugs.impl.bfs.BFSGraphSolver.Goal;
import code.exercise.twojugs.impl.bfs.BFSGraphSolver.Transition;

/**
 * BFS - Breadth First Search implementation for two jug problem
 * @author Saida Dhanavath
 *
 */
public class BFSTwoJugProblem extends AbstractTwoJugProblem {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public TwoJugResult getSolution(int sizeOfJugM, int sizeOfJugN,
			int sizeOfSolution) throws TwoJugException {
		
		if (!isSolvable(sizeOfJugM, sizeOfJugN, sizeOfSolution)) {
			throw new TwoJugProblemNotSolvableException("");
		}
		
		
		BFSGraphSolver solver=new BFSGraphSolver();
		
		List results=solver.bfs(
				new PouringSequence(0,0,"Initial state"),
				new SolutionGoal(sizeOfSolution), 
				new DiscoverJugStates(sizeOfJugM, sizeOfJugN));
		
		return new TwoJugResult(results);
	}
	/**
	 * Implementation of the Goal interface; used to identify when goal state is reached
	 * 
	 * @author Saida Dhanavath
	 *
	 */
	public class SolutionGoal implements Goal<PouringSequence> {
		int sizeOfSolution;
		public SolutionGoal(int sizeOfSolution) {
			this.sizeOfSolution = sizeOfSolution;
		}
		@Override
		public boolean isGoal(PouringSequence sequence) {
			if (sequence.getSizeOfJugM() == sizeOfSolution || sequence.getSizeOfJugN() == sizeOfSolution) {
				return true;
			}
			return false;
		}
		
	}
	
	/**
	 * Implemenation of the Transition interface; used to generate new transition states
	 * from a given node (blind search). Uses heuristics based on problem statement to 
	 * determine a next state.
	 * 
	 * @author Saida Dhanavath
	 *
	 */
	public class DiscoverJugStates implements Transition<PouringSequence> {
		private int sizeOfJugM;
		private int sizeOfJugN;
		public DiscoverJugStates(int sizeOfJugM, int sizeOfJugN) {
			this.sizeOfJugM = sizeOfJugM;
			this.sizeOfJugN = sizeOfJugN;
		}
		@Override
		public List<PouringSequence> transitions(PouringSequence currentSequence) {
			List<PouringSequence> list = new ArrayList<PouringSequence>();
	        int x = currentSequence.getSizeOfJugM();
	        int y = currentSequence.getSizeOfJugN();
	        int b1 = sizeOfJugM;
	        int b2 = sizeOfJugN;
	        if (x < b1 && y > 0) {
	            // move partial from y to x
	            int partial = Math.min(y, b1 - x);
	            String transition = "Pour "+b2+"L Jug into "+b1+"L Jug";
	            list.add(new PouringSequence(x + partial, y - partial, transition));
	        }
	        if (y < b2 && x > 0) {
	            // move partial from x to y
	            int partial = Math.min(x, b2 - y);
	            String transition = "Pour "+b1+"L Jug into "+b2+"L Jug";
	            list.add(new PouringSequence(x - partial, y + partial, transition));
	        }
	        if (x > 0) {
	            // empty x
	            String transition = "Empty "+b1+"L Jug";
	            list.add(new PouringSequence(0, y, transition));
	        }
	        if (y > 0) {
	            // empty y
	            String transition = "Empty "+b2+"L Jug";
	            list.add(new PouringSequence(x, 0, transition));
	        }
	        if (x < b1) {
	            // fill x
	            String transition = "Fill "+b1+"L Jug";
	            list.add(new PouringSequence(b1, y, transition));
	        }
	        if (y < b2) {
	            // fill y
	            String transition = "Fill "+b2+"L Jug";
	            list.add(new PouringSequence(x, b2, transition));
	        }
			return list;
		}
		
	}

}
