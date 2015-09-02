package code.exercise.twojugs.util;

import java.math.BigInteger;
/**
 * Utilities help to solve two jug problem
 * @author Saida Dhanavath
 *
 */
public class TwoJugUtil {
	/**
	 * Returns a BigInteger whose value is the greatest common divisor of two
	 * input parameters.
	 * 
	 * @param a
	 *            - value with which the GCD is to be computed.
	 * @param b
	 *            - value with which the GCD is to be computed.
	 * @return - the GCD.
	 */
	public static BigInteger gcd(BigInteger a, BigInteger b) {
		return a.gcd(b);
	}

	/**
	 * Returns a number GCD(Greatest Common Divisor) between two positive
	 * integers using simple recursion.
	 * 
	 * @param a - positive integer 1
	 * @param b - positive integer 2
	 * @return
	 */
	public static int gcd(int a, int b) {
		if (0 == b) {
			return a;
		}
		return gcd(b, a % b);
	}
}
