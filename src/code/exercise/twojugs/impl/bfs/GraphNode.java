package code.exercise.twojugs.impl.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a node of a graph. The node contains a collection of
 * connected nodes representing the nodes directly connected to this node via an
 * edge. The node also contains a generic data type and a flag to mark if it was
 * visited by the search algorithm.
 * 
 * @author Saida Dhanavath
 * 
 * @param <T>
 */
class GraphNode<T> {

	List<GraphNode<T>> edges = new ArrayList<GraphNode<T>>();
	T data;
	boolean visited;

	public GraphNode(T data) {
		this.data = data;
		this.visited = false;
	}

	public void addEdge(GraphNode<T> node) {
		this.edges.add(node);
	}
}
