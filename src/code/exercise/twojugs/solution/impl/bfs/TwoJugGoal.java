package code.exercise.twojugs.solution.impl.bfs;

import code.exercise.twojugs.solution.data.PouringSequence;

public class TwoJugGoal implements Goal<PouringSequence> {
    int sizeOfSolution;

    public TwoJugGoal(int sizeOfSolution) {
        this.sizeOfSolution = sizeOfSolution;
    }

    @Override
    public boolean isGoalAchieved(PouringSequence sequence) {
        if (sequence.getSizeOfFirstJug() == sizeOfSolution
                || sequence.getSizeOfSecondJug() == sizeOfSolution) {

            return true;
        }
        return false;
    }

}
