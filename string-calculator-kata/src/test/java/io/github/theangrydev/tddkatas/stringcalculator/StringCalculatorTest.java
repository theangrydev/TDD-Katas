package io.github.theangrydev.tddkatas.stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

	@Test
	public void theSumOfOneNumberIsItself() {
		assertThat(stringCalculator.add("5")).isEqualTo(5);
	}

	@Test
	public void theSumOfTwoNumberIsTheFirstPlusTheSecond() {
		assertThat(stringCalculator.add("1,2")).isEqualTo(3);
	}

	@Test
	public void newLinesCanBeUsedToSeperate() {
		assertThat(stringCalculator.add("1\n2,3")).isEqualTo(6);
	}

	@Test
	public void onlyOneSeperatorIsAllowedBetweenNumbers() {
		assertThatThrownBy(() -> stringCalculator.add("1\n,2")).isInstanceOf(NumberFormatException.class);
	}
}
