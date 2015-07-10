package io.github.theangrydev.tddkatas.bowlinggame;

public class Game {

	private int lastRoll;
	private int currentRoll;
	private boolean[] strikes = new boolean[20];
	private boolean[] spares = new boolean[20];
	private int score;

	public void roll(int pins) {
		if (pins == 10) {
			strikes[currentRoll] = true;
		} else if (pins + lastRoll == 10 && !theLastRollWasAStrike() && !theLastRollWasASpare()) {
			spares[currentRoll] = true;
		}
		score += pins;
		if (theLastRollWasASpare() || theLastRollWasAStrike() || theRollBeforeLastWasAStrike()) {
			score += pins;
		}
		lastRoll = pins;
		currentRoll++;
	}

	private boolean theRollBeforeLastWasAStrike() {
		return currentRoll >= 2 && strikes[currentRoll - 2];
	}

	private boolean theLastRollWasAStrike() {
		return currentRoll >= 1 && strikes[currentRoll - 1];
	}

	private boolean theLastRollWasASpare() {
		return currentRoll >= 1 && spares[currentRoll - 1];
	}

	public int score() {
		return score;
	}
}
