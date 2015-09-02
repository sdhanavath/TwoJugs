package code.exercise.twojugs.data;

import java.util.List;

/**
 * TwoJugResult container for two jug solution.
 * 
 * @author Saida Dhanavath
 * 
 */
public class TwoJugResult implements java.io.Serializable {

	private static final long serialVersionUID = -8525014126279096535L;
	final List<PouringSequence> pouringSequence;

	public TwoJugResult(List<PouringSequence> pouringSequence) {
		this.pouringSequence = pouringSequence;
	}

	public int getPouringSequenceSize() {
		return pouringSequence.size() - 1;
	}

	public String conciseInstructions() {
		StringBuilder step = new StringBuilder();
		for (PouringSequence sequence : pouringSequence) {
			step.append(sequence.toString());
			step.append("\n");
		}
		return step.toString();
	}

	public String prettyInstructions() {
		StringBuilder step = new StringBuilder();
		for (int i = 0; i < pouringSequence.size(); i++) {
			step.append(pouringSequence.get(i).toString());
			if (i < pouringSequence.size() - 1)
				step.append("-->");
		}
		return step.toString();
	}
	
	public String verboseInstructions() {
		StringBuilder step = new StringBuilder();
		for (PouringSequence sequence : pouringSequence) {
			step.append(sequence.toVerboseString());
			step.append("\n");
		}
		return step.toString();
	}

	public int numberOfPouringSteps() {
		return pouringSequence.size() - 1;
	}

}
