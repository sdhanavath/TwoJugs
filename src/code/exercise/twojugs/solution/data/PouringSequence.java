package code.exercise.twojugs.solution.data;

import java.io.Serializable;

public class PouringSequence implements Serializable {

    private static final long serialVersionUID = -3713080874237257845L;

    private int sizeOfFirstJug;
    private int sizeOfSecondJug;
    private String transition;

    public PouringSequence(int sizeOfFirstJug, int sizeOfSecondJug,
            String transition) {
        this.sizeOfFirstJug = sizeOfFirstJug;
        this.sizeOfSecondJug = sizeOfSecondJug;
        this.transition = transition;
    }

    public int getSizeOfFirstJug() {
        return sizeOfFirstJug;
    }

    public int getSizeOfSecondJug() {
        return sizeOfSecondJug;
    }

    public String getTransition() {
        return transition;
    }

    public String toVerboseString() {
        return transition + "\t" + toString();
    }

    @Override
    public String toString() {
        return "(" + sizeOfFirstJug + "," + sizeOfSecondJug + ")";
    }

}
