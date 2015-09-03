package code.exercise.twojugs.client;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import code.exercise.twojugs.solution.TwoJugSolution;
import code.exercise.twojugs.solution.data.TwoJugResult;
import code.exercise.twojugs.solution.exception.TwoJugException;
import code.exercise.twojugs.solution.impl.bfs.BFSTwoJugSolution;

/**
 * Sample Client program for Two Jug Puzzle solution.
 * 
 * @author Saida Dhanavath
 * 
 */
public class TwoJugProblemClient {

    static int sizeOfJugM, sizeOfJugN, sizeOfSolution;
    static Scanner scanner;
    static TwoJugResult solution;
    static String ch;
    

    public static void main(String[] args) {

        final Logger LOGGER = LoggerFactory
                .getLogger(TwoJugProblemClient.class);

        System.out
                .println("==================================================================================");
        System.out.println("\t\t\tWelcome to Two Water Jug Problem!!!\t\t\t");
        System.out
                .println("==================================================================================");

        scanner = new Scanner(System.in);
        do {
            try {
                readInput();
                callPuzzleSolver();
                displaySolution();
                askToSolveMorePuzzles();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (ch.equalsIgnoreCase("Y"));
    }

    static void callPuzzleSolver() {
        TwoJugSolution twoJugProblem = new BFSTwoJugSolution();
        try {
            solution = twoJugProblem.getSolution(sizeOfJugM, sizeOfJugN,
                    sizeOfSolution);
        } catch (TwoJugException e) {
            e.printStackTrace();
        }
    }

    static void readInput() {
        System.out
                .println("(Example(SizeOfJug-M,SizeOfJug-N and the size to be measured(SizeOfSolution)): 3 5 4");
        System.out.println("Enter Two Jug Sizes and Desired size to measure");
        sizeOfJugM = scanner.nextInt();
        sizeOfJugN = scanner.nextInt();
        sizeOfSolution = scanner.nextInt();
    }

    static void displaySolution() {
        System.out
                .println("::::::::::::::::::::::::SOLUTION::::::::::::::::::::::::::::::::::::::");
        System.out.println("Number of Pouring Steps Required:"
                + solution.numberOfPouringSteps());
        System.out.println("Pouring Sequence:\n"
                + solution.prettyInstructions());

        System.out.println("Pouring Sequence details:");
        System.out.println(solution.verboseInstructions());
        System.out
                .println(":::::::::::::::::::::::::::END:::::::::::::::::::::::::::::::::::::::::");
    }

    static void askToSolveMorePuzzles() {
        System.out
                .println("Please Enter 'Y' - to continue solving more puzzles.(or) 'N' - to quit.");
        ch = scanner.next();
    }

}
