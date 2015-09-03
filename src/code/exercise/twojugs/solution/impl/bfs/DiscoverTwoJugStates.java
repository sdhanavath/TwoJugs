package code.exercise.twojugs.solution.impl.bfs;

import java.util.ArrayList;
import java.util.List;

import code.exercise.twojugs.solution.data.PouringSequence;

public class DiscoverTwoJugStates implements Transition<PouringSequence> {
    private int sizeOfFirstJug;
    private int sizeOfSecondJug;
    private static final String FILL = "Fill ";
    private static final String POUR = "Pour ";
    private static final String EMPTY = "Empty ";
    private static final String JUG = "Jug ";
    private static final String LITER = "L ";
    private static final String INTO = "into ";

    public DiscoverTwoJugStates(int sizeOfFirstJug, int sizeOfSecondJug) {
        this.sizeOfFirstJug = sizeOfFirstJug;
        this.sizeOfSecondJug = sizeOfSecondJug;
    }

    @Override
    public List<PouringSequence> transitions(PouringSequence currentSequence) {
        List<PouringSequence> list = new ArrayList<PouringSequence>();
        int x = currentSequence.getSizeOfFirstJug();
        int y = currentSequence.getSizeOfSecondJug();
        int b1 = sizeOfFirstJug;
        int b2 = sizeOfSecondJug;
        if (x < b1 && y > 0) {
            // move partial from y to x
            int partial = Math.min(y, b1 - x);
            String transition = POUR + b2 + LITER + JUG + INTO + b1 + LITER
                    + JUG;
            list.add(new PouringSequence(x + partial, y - partial, transition));
        }
        if (y < b2 && x > 0) {
            // move partial from x to y
            int partial = Math.min(x, b2 - y);
            String transition = POUR + b1 + LITER + JUG + INTO + b2 + LITER
                    + JUG;
            list.add(new PouringSequence(x - partial, y + partial, transition));
        }
        if (x > 0) {
            // empty x
            String transition = EMPTY + b1 + LITER + JUG;
            list.add(new PouringSequence(0, y, transition));
        }
        if (y > 0) {
            // empty y
            String transition = EMPTY + b2 + LITER + JUG;
            list.add(new PouringSequence(x, 0, transition));
        }
        if (x < b1) {
            // fill x
            String transition = FILL + b1 + LITER + JUG;
            list.add(new PouringSequence(b1, y, transition));
        }
        if (y < b2) {
            // fill y
            String transition = FILL + b2 + LITER + JUG;
            list.add(new PouringSequence(x, b2, transition));
        }
        return list;
    }
    
}
