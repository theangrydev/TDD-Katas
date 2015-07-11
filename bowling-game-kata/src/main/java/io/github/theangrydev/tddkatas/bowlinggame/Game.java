package io.github.theangrydev.tddkatas.bowlinggame;

public class Game {

	private int lastRoll;
	private int currentRoll;
	private int rollsThisFrame;
	private int frameNumber = 1;
	private boolean[] strikes = new boolean[20];
	private boolean[] spares = new boolean[20];
	private int score;

	public void roll(int pins) {
		score += pins;
		if (!theFirstBonusRollHasBeenMade() && (theLastRollWasASpare() || theLastRollWasAStrike())) {
			score += pins;
		}
		if (!theSecondBonusRollHasBeenMade() && theRollBeforeLastWasAStrike()) {
			score += pins;
		}
		if (thisRollIsAStrike(pins)) {
			rememberThatThisRollIsAStrike();
		} else if (thisRollIsASpare(pins)) {
			rememberThatThisRollIsASpare();
		} else {
			rememberThatThisRollIsNotAStrikeOrASpare();
		}
		lastRoll = pins;
		currentRoll++;
	}

	private boolean theFirstBonusRollHasBeenMade() {
		return thisIsTheLastFrame() && rollsThisFrameIsAtLeast(1);
	}

	private boolean theSecondBonusRollHasBeenMade() {
		return thisIsTheLastFrame() && rollsThisFrameIsAtLeast(2);
	}

	private boolean rollsThisFrameIsAtLeast(int numberOfRolls) {
		return rollsThisFrame >= numberOfRolls;
	}

	private boolean thisIsTheLastFrame() {
		return frameNumber == 10;
	}

	public int score() {
		return score;
	}

	private boolean thisRollIsASpare(int pins) {
		return theNumberOfPinsKnockedDownInThisRollAndTheLastIsTen(pins) && !theLastRollWasAStrike();
	}

	private boolean thisRollIsAStrike(int pins) {
		return pins == 10;
	}

	private boolean theNumberOfPinsKnockedDownInThisRollAndTheLastIsTen(int pins) {
		return pins + lastRoll == 10;
	}

	private void rememberThatThisRollIsNotAStrikeOrASpare() {
		if (haveRolledThisFrame()) {
			rememberThatTwoRollsHaveBeenMadeInAFrame();
		}
	}

	private boolean haveRolledThisFrame() {
		return rollsThisFrame > 0;
	}

	private void moveToTheNextFrame() {
		frameNumber++;
		rollsThisFrame = 0;
	}

	private void rememberThatThisRollIsASpare() {
		rememberThatTwoRollsHaveBeenMadeInAFrame();
		spares[currentRoll] = true;
	}

	private void rememberThatThisRollIsAStrike() {
		rememberThatTwoRollsHaveBeenMadeInAFrame();
		strikes[currentRoll] = true;
	}

	private void rememberThatTwoRollsHaveBeenMadeInAFrame() {
		if (!thisIsTheLastFrame()) {
			moveToTheNextFrame();
		} else {
			rollsThisFrame++;
		}
	}

	private boolean theRollBeforeLastWasAStrike() {
		return thereHasBeenAtLeastTwoRolls() && thereWasAStrikeThisManyRollsAgo(2);
	}

	private boolean thereWasAStrikeThisManyRollsAgo(int thisManyRollsAgo) {
		return strikes[currentRoll - thisManyRollsAgo];
	}

	private boolean theLastRollWasAStrike() {
		return thereHasBeenAtLeastOneRoll() && thereWasAStrikeThisManyRollsAgo(1);
	}

	private boolean theLastRollWasASpare() {
		return thereHasBeenAtLeastOneRoll() && thereWasASpareThisManyRollsAgo(1);
	}

	private boolean thereWasASpareThisManyRollsAgo(int thisManyRollsAgo) {
		return spares[currentRoll - thisManyRollsAgo];
	}

	private boolean thereHasBeenAtLeastTwoRolls() {
		return currentRoll >= 2;
	}

	private boolean thereHasBeenAtLeastOneRoll() {
		return currentRoll >= 1;
	}
}
