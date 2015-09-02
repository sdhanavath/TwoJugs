package code.exercise.twojugs.client;

import java.util.Scanner;

import code.exercise.twojugs.TwoJugProblem;
import code.exercise.twojugs.data.TwoJugResult;
import code.exercise.twojugs.exception.TwoJugException;
import code.exercise.twojugs.impl.bfs.BFSTwoJugProblem;


/**
 * Sample Client program for TwoJugProblem.
 * 
 * @author Saida Dhanavath
 * 
 */
public class TwoJugProblemClient {

	public static void main(String[] args) {

		System.out.println("=====================================");
		System.out.println("\tWelcome to Two Jug Problem!!!\t");
		System.out.println("=====================================");

		System.out.println("Enter Two Jug Sizes and Desired size to measure");
		System.out.println("(Example(JugM,JugN and size to measure): 3 5 4");
		Scanner sc = new Scanner(System.in);
		int sizeOfJugM = sc.nextInt();
		int sizeOfJugN = sc.nextInt();
		int sizeOfSolution = sc.nextInt();
		sc.close();

		TwoJugProblem twoJugProblem = new BFSTwoJugProblem();

		try {
			TwoJugResult result = twoJugProblem.getSolution(sizeOfJugM,
					sizeOfJugN, sizeOfSolution);
			//System.out.println("Pouring Sequence:\n"+result.conciseInstructions());
			System.out.println("Pouring Sequence:\n"+result.prettyInstructions());
			System.out.println("The number of pouring steps invloved in achiving the solution:"+result.numberOfPouringSteps());
			System.out.println("Pouring Sequence details:");
			System.out.println(result.verboseInstructions());
			
		} catch (TwoJugException e) {
			e.printStackTrace(); 		}

	}

}
