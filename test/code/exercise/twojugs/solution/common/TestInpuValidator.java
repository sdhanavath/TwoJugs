package code.exercise.twojugs.solution.common;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.exercise.twojugs.solution.solution.common.InputValidator;

public class TestInpuValidator {

    @Test(expected=IllegalArgumentException.class)
    public void testIfSizeOfFirstJugIsNegative(){
        InputValidator.validate(-1, 0, 0);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIfSizeOfBothFirstAndSecondJugIsNegative(){
        InputValidator.validate(-1, -1, 0);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIfSizeIsNegative(){
        InputValidator.validate(1, 1, -1);
    }

    @Test
    public void testIfAllArePositive(){
        assertTrue(InputValidator.validate(1, 1, 1));
    }

}
