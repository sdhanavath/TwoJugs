package code.exercise.twojugs.solution.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.exercise.twojugs.solution.solution.common.InputValidator;

public class TestInpuValidator {

    @Test
    public void testIfSizeOfFirstJugIsNegative() {
        assertFalse(InputValidator.validate(-1, 0, 0));
    }

    @Test
    public void testIfSizeOfBothFirstAndSecondJugIsNegative() {
        assertFalse(InputValidator.validate(-1, -1, 0));
    }

    @Test
    public void testIfSizeIsNegative() {
        assertFalse(InputValidator.validate(1, 1, -1));
    }

    @Test
    public void testIfAllArePositive() {
        assertTrue(InputValidator.validate(1, 1, 1));
    }

}
