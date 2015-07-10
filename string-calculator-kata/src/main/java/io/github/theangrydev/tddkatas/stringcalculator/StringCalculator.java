package io.github.theangrydev.tddkatas.stringcalculator;

import static java.lang.Integer.parseInt;

public class StringCalculator {

	public int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		return parseInt(numbers);
	}
}
