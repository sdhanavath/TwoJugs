package code.exercise.twojugs.solution.solution.common;

public class InputValidator {

    private InputValidator() {

    }

    public static boolean validate(int sizeOfFirstJug, int sizeOfSecondJug,
            int sizeToBeMeasured) {

        if (sizeToBeMeasured > sizeOfFirstJug
                && sizeToBeMeasured > sizeOfSecondJug)
            return false;

        if (sizeOfFirstJug < 0 || sizeOfSecondJug < 0 || sizeToBeMeasured < 0)
            return false;

        return true;
    }

}
