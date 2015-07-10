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

		assertThat(theFinalScore()).isEqualTo(0);
	}

	@Test
	public void aGameWithOnePinKnockedDownEachTimeShouldScore20() {
		givenEveryRollScores(1);

		assertThat(theFinalScore()).isEqualTo(20);
	}

	private int theFinalScore() {
		return game.score();
	}

	private void givenEveryRollScores(int pinsEachRoll) {
		for (int i = 0; i < 20; i++) {
			game.roll(pinsEachRoll);
		}
	}
}
