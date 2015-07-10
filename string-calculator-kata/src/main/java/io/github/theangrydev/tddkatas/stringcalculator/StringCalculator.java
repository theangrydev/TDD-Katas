package io.github.theangrydev.tddkatas.stringcalculator;

import com.google.common.base.Splitter;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StringCalculator {

	public int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		return stream(eachNumber(numbers)).mapToInt(Integer::parseInt).sum();
	}

	private Iterable<String> eachNumber(String numbers) {
		return Splitter.onPattern("[,\n]").split(numbers);
	}

	private static <T> Stream<T> stream(Iterable<T> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false);
	}
}
