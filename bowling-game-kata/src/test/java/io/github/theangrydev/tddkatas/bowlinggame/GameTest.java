package io.github.theangrydev.tddkatas.bowlinggame;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

	@Test
	public void gutterGameShouldScoreZero() {
		Game game = new Game();
		for (int i = 0; i < 20; i++) {
			game.roll(0);
		}
		assertThat(game.score()).isEqualTo(0);
	}
}
