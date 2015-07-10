package io.github.theangrydev.tddkatas.bowlinggame;

public class Game {

	private boolean lastRollWasASpare;
	private int lastRoll;
	private int score;

	public void roll(int pins) {
		if (lastRollWasASpare) {
			score += pins * 2;
		} else {
			score += pins;
		}
		lastRollWasASpare = pins + lastRoll == 10;
		lastRoll = pins;
	}

	public int score() {
		return score;
	}
}
