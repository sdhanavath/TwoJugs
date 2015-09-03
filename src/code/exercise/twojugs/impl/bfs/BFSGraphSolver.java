package code.exercise.twojugs.impl.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import code.exercise.twojugs.exception.TwoJugException;
import code.exercise.twojugs.exception.TwoJugTechnicalException;

/**
 * Generic BFS search graph solver with implementation for blind BFS
 * 
 * @author Saida Dhanavath
 * 
 * @param <T>
 */
public class BFSGraphSolver<T> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(BFSTwoJugProblem.class);

	// this field is used to save/container of the Graph.
	private Map<String, String> exists;
	// this field is used to backtrack from target to root while generating the
	// solution.
	private Map<GraphNode<T>, GraphNode<T>> path;

	/**
	 * Generic Breadth First Search given a root node in a graph, a goal node to
	 * search for, and an object which generates transition states from a given
	 * state. Returns back the List<T> representing the path of <T> states from
	 * root to the goal.
	 * 
	 * @param root
	 *            - Initial state, JUG(M,N)==>(0,0) in this case.
	 * @param goal
	 *            - Goal state, size to be measured in this case.
	 * @param transition
	 *            - Initial transition container, JUG(M,N) in this case
	 * @return Returns the pouring sequence path
	 */
	public List<T> searchForSolution(T root, Goal<T> goal,
			Transition<T> transition) throws TwoJugException {
		LOGGER.info("Searching for solution");

		if (null == root || null == goal || null == transition) {
			throw new TwoJugTechnicalException("Input object is null");
		}
		exists = new HashMap<String, String>();
		path = new HashMap<GraphNode<T>, GraphNode<T>>();
		// queue to hold successor nodes
		Queue<GraphNode<T>> queue = new LinkedList<GraphNode<T>>();
		// root node
		GraphNode<T> start = new GraphNode<T>(root);
		// begin by marking root visited and enqueing
		visit(start, null);
		queue.offer(start);

		// continue until queue empty
		while (!queue.isEmpty()) {
			GraphNode<T> targetNode = queue.remove();
			// Check is this the goal
			if (goal.isGoal(targetNode.data)) {
				return buildSolution(targetNode);
			}
			// blind search uses transition object to generate edges to this
			// node
			// on the fly
			populateEdges(targetNode, transition);

			// traverse these generated edges
			for (GraphNode<T> edge : targetNode.edges) {
				// if not visited, visit and queue
				if (!edge.visited) {
					visit(edge, targetNode);
					queue.offer(edge);
					// check for goal
					if (goal.isGoal(edge.data)) {
						return buildSolution(edge);
					}
				}
			}
		}
		return new ArrayList<T>();
	}

	/**
	 * Generate transition state nodes from given node using given Transition
	 * object. Use the exists Map to prune previously traversed states. Add
	 * un-pruned nodes to the given node as an edge.
	 * 
	 * @param node
	 * @param transition
	 */
	private void populateEdges(GraphNode<T> node, Transition<T> transition) {
		// successor states
		for (T mixture : transition.transitions((T) node.data)) {
			String key = mixture.toString();
			if (!exists.containsKey(key)) {
				exists.put(key, key);
				node.addEdge(new GraphNode<T>(mixture));
			}
		}
	}

	/**
	 * The purpose is to construct the solution by backtracking starting from
	 * goal/target state until root is reached, add each nodes data to a
	 * collection and Reverse the collection to represent the forward sequence
	 * of data.
	 * 
	 * @param target
	 *            - goal state
	 * @return - pouring sequence path.
	 */
	private List<T> buildSolution(GraphNode<T> target) {
		LOGGER.info("Building the solution path");
		List<T> solution = new ArrayList<T>();
		while (null != target) {
			solution.add((T) target.data);
			target = path.get(target);
		}
		Collections.reverse(solution);
		return solution;
	}

	/**
	 * helper method to mark node visited. Add to path.
	 * 
	 * @param node
	 * @param parent
	 */
	private void visit(GraphNode<T> node, GraphNode<T> parent) {
		node.visited = true;
		path.put(node, parent);
	}

}
