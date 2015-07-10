package io.github.theangrydev.tddkatas.stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

	private StringCalculator stringCalculator;

	@Before
	public void setUp() {
		stringCalculator = new StringCalculator();
	}

	@Test
	public void theSumOfNoNumbersIsZero() {
		assertThat(stringCalculator.add("")).isEqualTo(0);
	}
}
