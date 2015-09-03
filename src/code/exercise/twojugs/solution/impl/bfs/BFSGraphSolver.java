package code.exercise.twojugs.solution.impl.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import code.exercise.twojugs.solution.exception.TwoJugException;
import code.exercise.twojugs.solution.solution.common.TwoJugConstant;

public class BFSGraphSolver<T> {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(BFSTwoJugSolution.class);

    private Map<String, String> graphContainer;
    private Map<GraphNode<T>, GraphNode<T>> path;
    Queue<GraphNode<T>> queue;
    Goal<T> goal;

    public List<T> searchForSolution(T root, Goal<T> goal,
            Transition<T> transition) throws TwoJugException {
        LOGGER.info(TwoJugConstant.SearchingForSolution.getMessage());

        graphContainer = new HashMap<String, String>();
        path = new HashMap<GraphNode<T>, GraphNode<T>>();
        queue = new LinkedList<GraphNode<T>>();
        GraphNode<T> start = new GraphNode<T>(root);
        visit(start, null);
        queue.offer(start);

        while (!queue.isEmpty()) {
            GraphNode<T> targetNode = queue.remove();
            // Check is this the goal
            if (goal.isGoalAchieved(targetNode.data)) {
                return buildSolution(targetNode);
            }
            // blind search uses transition object to generate edges to this
            // node on the fly
            populateEdges(targetNode, transition);

            // traverse these generated edges
            for (GraphNode<T> edge : targetNode.edges) {
                // if not visited, visit and enqueue
                if (!edge.visited) {
                    visit(edge, targetNode);
                    queue.offer(edge);
                    // check for goal
                    if (goal.isGoalAchieved(edge.data)) {
                        return buildSolution(edge);
                    }
                }
            }
        }
        return new ArrayList<T>();
    }

    private void populateEdges(GraphNode<T> node, Transition<T> transition) {
        for (T mixture : transition.transitions((T) node.data)) {
            String key = mixture.toString();
            if (!graphContainer.containsKey(key)) {
                graphContainer.put(key, key);
                node.addEdge(new GraphNode<T>(mixture));
            }
        }
    }

    private List<T> buildSolution(GraphNode<T> target) {
        List<T> solution = new ArrayList<T>();
        GraphNode<T> tempTarget = target;
        while (null != tempTarget) {
            solution.add((T) tempTarget.data);
            tempTarget = path.get(tempTarget);
        }
        Collections.reverse(solution);
        return solution;
    }

    private void visit(GraphNode<T> node, GraphNode<T> parent) {
        node.visited = true;
        path.put(node, parent);
    }

}
