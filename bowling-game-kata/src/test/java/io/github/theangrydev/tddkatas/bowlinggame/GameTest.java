package io.github.theangrydev.tddkatas.bowlinggame;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

	private Game game;

	@Before
	public void setUp() {
		game = new Game();
	}

	@Test
	public void aGutterGameShouldScoreZero() {
		givenEveryRollScores(0);

		assertThat(theScore()).isEqualTo(0);
	}

	@Test
	public void aGameWithOnePinKnockedDownEachTimeShouldScore20() {
		givenEveryRollScores(1);

		assertThat(theScore()).isEqualTo(20);
	}

	@Test
	public void aSpareGrantsABonusEqualToTheNumberOfPinsKnockedDownInTheNextRoll() {
		rollASpare();
		roll(5);

		assertThat(theScore()).isEqualTo(10 + 5*2);
	}

	@Test
	public void aSpareDoesNotGrantsABonusEqualToTheNumberOfPinsKnockedDownOnTheSecondRollAfterTheStrike() {
		rollASpare();
		roll(5);
		roll(1);

		assertThat(theScore()).isEqualTo(10 + 5*2 + 1);
	}

	@Test
	public void aStrikeGrantsABonusEqualToTheNumberOfPinsKnockedDownInTheNextRoll() {
		rollAStrike();
		roll(4);

		assertThat(theScore()).isEqualTo(10 + 4*2);
	}

	@Test
	public void aStrikeGrantsABonusEqualToTheNumberOfPinsKnockedDownInTheNextTwoRolls() {
		rollAStrike();
		roll(4);
		roll(3);

		assertThat(theScore()).isEqualTo(10 + 4*2 + 3*2);
	}

	@Test
	public void aStrikeDoesNotGrantsABonusEqualToTheNumberOfPinsKnockedDownOnTheThirdRollAfterTheStrike() {
		rollAStrike();
		roll(4);
		roll(3);
		roll(5);

		assertThat(theScore()).isEqualTo(10 + 4*2 + 3*2 + 5);
	}

	private void rollAStrike() {
		roll(10);
	}

	private void rollASpare() {
		roll(1);
		roll(9);
	}

	private int theScore() {
		return game.score();
	}

	private void givenEveryRollScores(int pinsKnockedDownEachRoll) {
		for (int i = 0; i < 20; i++) {
			roll(pinsKnockedDownEachRoll);
		}
	}

	private void roll(int pinsKnockedDown) {
		game.roll(pinsKnockedDown);
	}
}
