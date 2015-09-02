package code.exercise.twojugs.client;

import java.util.Scanner;

import code.exercise.twojugs.TwoJugProblem;
import code.exercise.twojugs.data.TwoJugResult;
import code.exercise.twojugs.exception.TwoJugException;
import code.exercise.twojugs.impl.bfs.BFSTwoJugProblem;

/**
 * Sample Client program to test  Two Jug Puzzle solution.
 * 
 * @author Saida Dhanavath
 * 
 */
public class TwoJugProblemClient {

	static int sizeOfJugM, sizeOfJugN, sizeOfSolution;
	static Scanner sc;
	static TwoJugResult solution;
	static String ch;

	public static void main(String[] args) {

		System.out
				.println("==================================================================================");
		System.out.println("\t\t\tWelcome to Two Water Jug Problem!!!\t\t\t");
		System.out
				.println("==================================================================================");

		sc = new Scanner(System.in);
		do {
			// Step 1: for inputs
			inputPuzzle();
			// Step 2: call puzzle solver
			callPuzzleSolver();
			// Step 3: display the solution
			if(null!=solution)
			displaySolution();
			// Step 4: Ask to continue / quit
			askToSolveMorePuzzles();

		} while (ch.equalsIgnoreCase("Y"));
	}

	static void callPuzzleSolver() {
		TwoJugProblem twoJugProblem = new BFSTwoJugProblem();
		try {
			solution = twoJugProblem.getSolution(sizeOfJugM, sizeOfJugN,
					sizeOfSolution);
		} catch (TwoJugException e) {
			e.printStackTrace();
		}
	}

	static void inputPuzzle() {
		System.out
				.println("(Example(SizeOfJug-M,SizeOfJug-N and the size to be measured(SizeOfSolution)): 3 5 4");
		System.out.println("Enter Two Jug Sizes and Desired size to measure");
		sizeOfJugM = sc.nextInt();
		sizeOfJugN = sc.nextInt();
		sizeOfSolution = sc.nextInt();
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
		ch = sc.next();
	}

}
