package io.github.theangrydev.tddkatas.stringcalculator;

import org.junit.Test;

import static io.github.theangrydev.tddkatas.stringcalculator.StringCalculator.add;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

	@Test
	public void theSumOfNoNumbersIsZero() {
		assertThat(add("")).isEqualTo(0);
	}

	@Test
	public void theSumOfOneNumberIsItself() {
		assertThat(add("5")).isEqualTo(5);
	}

	@Test
	public void theSumOfTwoNumberIsTheFirstPlusTheSecond() {
		assertThat(add("1,2")).isEqualTo(3);
	}

	@Test
	public void newLinesCanBeUsedToSeperate() {
		assertThat(add("1\n2,3")).isEqualTo(6);
	}

	@Test
	public void onlyOneSeperatorIsAllowedBetweenNumbers() {
		assertThatThrownBy(() -> add("1\n,2")).isInstanceOf(NumberFormatException.class);
	}

	@Test
	public void differentDelimitersCanBeUsed() {
		assertThat(add(";\n1;2")).isEqualTo(3);
	}

	@Test
	public void negativesAreNotAllowed() {
		assertThatThrownBy(() -> add("-1")).hasMessage("Negatives are not allowed: -1");
	}

	@Test
	public void multipleNegativesAreNotAllowed() {
		assertThatThrownBy(() -> add("1,-1,-2")).hasMessage("Negatives are not allowed: -1,-2");
	}
}
