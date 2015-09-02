package code.exercise.twojugs.impl.bfs;

import java.util.List;

/**
 * Interface for identifying transitions from a given node
 * 
 * @author Saida Dhanavath
 * 
 * @param <T>
 */
public interface Transition<T> {
	List<T> transitions(T root);
}
