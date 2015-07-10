package io.github.theangrydev.tddkatas.stringcalculator;

import static java.util.Arrays.stream;

public class StringCalculator {

	public int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		return stream(numbers.split(",")).mapToInt(Integer::parseInt).sum();
	}
}
