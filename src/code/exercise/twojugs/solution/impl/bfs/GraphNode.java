package code.exercise.twojugs.solution.impl.bfs;

import java.util.ArrayList;
import java.util.List;

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
