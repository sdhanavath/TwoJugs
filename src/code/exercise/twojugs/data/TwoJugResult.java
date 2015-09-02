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
		return pouringSequence.size()-1;
	}

	public String conciseInstructions() {
		StringBuilder builder = new StringBuilder();
		for (PouringSequence sequence : pouringSequence) {
			builder.append(sequence.toString());
			builder.append("\n");
		}
		return builder.toString();
	}
	
	public String prettyInstructions() {
		StringBuilder builder = new StringBuilder();
		for (PouringSequence sequence : pouringSequence) {
			builder.append(sequence.toString());
			builder.append("-->");
		}
		return builder.toString();
	}

	public String verboseInstructions() {
		StringBuilder builder = new StringBuilder();
		for (PouringSequence sequence : pouringSequence) {
			builder.append(sequence.toVerboseString());
			builder.append("\n");
		}
		return builder.toString();
	}

	public int numberOfPouringSteps() {
		return pouringSequence.size() - 1;
	}

}
