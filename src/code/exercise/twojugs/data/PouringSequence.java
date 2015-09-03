package code.exercise.twojugs.data;

import java.io.Serializable;

/**
 * Pouring sequence data container.
 * 
 * @author Saida Dhanavath
 * 
 */
public class PouringSequence implements Serializable {

	private static final long serialVersionUID = -3713080874237257845L;

	private int sizeOfJugM;
	private int sizeOfJugN;
	private String transition;

	public int getSizeOfJugM() {
		return sizeOfJugM;
	}

	public void setSizeOfJugM(int sizeOfJugM) {
		this.sizeOfJugM = sizeOfJugM;
	}

	public int getSizeOfJugN() {
		return sizeOfJugN;
	}

	public void setSizeOfJugN(int sizeOfJugN) {
		this.sizeOfJugN = sizeOfJugN;
	}

	public String getTransition() {
		return transition;
	}

	public void setTransition(String transition) {
		this.transition = transition;
	}

	public PouringSequence(int sizeOfJugM, int sizeOfJugN, String transition) {
		this.sizeOfJugM = sizeOfJugM;
		this.sizeOfJugN = sizeOfJugN;
		this.transition = transition;
	}

	public String toVerboseString() {
		return transition + "\t" + toString();
	}

	@Override
	public String toString() {
		return "(" + sizeOfJugM + "," + sizeOfJugN + ")";
	}

}
