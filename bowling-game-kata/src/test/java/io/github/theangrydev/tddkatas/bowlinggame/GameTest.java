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
		roll(game, 0);

		assertThat(game.score()).isEqualTo(0);
	}

	@Test
	public void aGameWithOnePinKnockedDownEachTimeShouldScore20() {
		roll(game, 1);

		assertThat(game.score()).isEqualTo(20);
	}

	private void roll(Game game, int pinsEachRoll) {
		for (int i = 0; i < 20; i++) {
			game.roll(pinsEachRoll);
		}
	}
}
