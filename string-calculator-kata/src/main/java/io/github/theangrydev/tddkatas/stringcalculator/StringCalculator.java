package io.github.theangrydev.tddkatas.stringcalculator;

import com.google.common.base.Splitter;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.apache.commons.lang3.math.NumberUtils.isDigits;

public class StringCalculator {

	public static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		int endOfFirstLine = numbers.indexOf('\n');
		if (endOfFirstLine > 0) {
			String delimiter = numbers.substring(0, endOfFirstLine);
			if (!isDigits(delimiter)) {
				numbers = numbers.substring(endOfFirstLine + 1);
				return sum(Splitter.on(delimiter).split(numbers));
			}
		}
		return sum(numbersSplitByNewLineOrComma(numbers));
	}

	private static int sum(Iterable<String> numbers) {
		return stream(numbers).mapToInt(Integer::parseInt).sum();
	}

	private static Iterable<String> numbersSplitByNewLineOrComma(String numbers) {
		return Splitter.onPattern("[,\n]").split(numbers);
	}

	private static <T> Stream<T> stream(Iterable<T> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false);
	}
}
