package code.exercise.twojugs.problem.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import code.exercise.twojugs.solution.TwoJugSolution;
import code.exercise.twojugs.solution.data.TwoJugResult;
import code.exercise.twojugs.solution.exception.TwoJugException;
import code.exercise.twojugs.solution.impl.bfs.BFSTwoJugSolution;
import code.exercise.twojugs.solution.solution.common.InputValidator;

public class TwoJugProblemClient {

    static int sizeOfFirstJug, sizeOfSecondJug, sizeToBeMeasured;
    static Scanner scanner;
    static TwoJugResult solution;

    private static final Logger LOGGER = LoggerFactory
            .getLogger(TwoJugProblemClient.class);

    private TwoJugProblemClient() {

    }

    public static void main(String[] args) {

        LOGGER.info("==================================================================================");
        LOGGER.info("\t\t\tWelcome to Two Water Jug Problem!!!\t\t\t");
        LOGGER.info("==================================================================================");
        LOGGER.info("(SizeOfFirstJug,SizeOfSecondJug,sizeToBeMeasured): 3 5 4");

        scanner = new Scanner(System.in);
        do {
            try {
                readInput();
                if (validateInput()) {
                    callPuzzleSolver();
                    displaySolution();
                } else {
                    LOGGER.info("Invalid Inputs!!!");
                }
            } catch (InputMismatchException e) {
                LOGGER.info("Input Mismatch Exception Occured: Enter only numbers");
            } catch (TwoJugException e) {
                LOGGER.info("TwoJugException occured:" + e.getMessage());
            }
        } while (doYouWantToContinue().equalsIgnoreCase("Y"));
    }

    static boolean validateInput() {
        return InputValidator.validate(sizeOfFirstJug, sizeOfSecondJug,
                sizeToBeMeasured);

    }

    static void readInput() {
        LOGGER.info("Enter Two Jug Sizes and Desired size to measure");
        sizeOfFirstJug = scanner.nextInt();
        sizeOfSecondJug = scanner.nextInt();
        sizeToBeMeasured = scanner.nextInt();
    }

    static void callPuzzleSolver() throws TwoJugException {
        TwoJugSolution twoJugProblem = new BFSTwoJugSolution();
        solution = twoJugProblem.getSolution(sizeOfFirstJug, sizeOfSecondJug,
                sizeToBeMeasured);
    }

    static void displaySolution() {
        LOGGER.info("::::::::::::::::::::::::SOLUTION::::::::::::::::::::::::::::::::::::::");
        LOGGER.info("Number of Pouring Steps Required:"
                + solution.numberOfPouringSteps());
        LOGGER.info("Pouring Sequence:\n" + solution.prettyInstructions());
        LOGGER.info("Pouring Sequence details:");
        LOGGER.info(solution.verboseInstructions());
        LOGGER.info(":::::::::::::::::::::::::::END:::::::::::::::::::::::::::::::::::::::::");
    }

    static String doYouWantToContinue() {
        LOGGER.info("Please Enter 'Y' - to continue solving more puzzles.(or) 'N' - to quit.");
        return scanner.next();
    }

}
