package code.exercise.twojugs.solution.impl.bfs;

import java.util.List;

public interface Transition<T> {
    List<T> transitions(T root);
}
