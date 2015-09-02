package code.exercise.twojugs.impl.bfs;

/**
 * Interface for identifying if given candidate node satisfied goal state
 * 
 * @author Saida Dhanavath
 * 
 * @param <T>
 */
public interface Goal<T> {
	boolean isGoal(T candidate);
}
