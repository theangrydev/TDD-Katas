package io.github.theangrydev.tddkatas.stringcalculator;

import com.google.common.base.Splitter;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StringCalculator {

	public int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		int endOfFirstLine = numbers.indexOf('\n');
		if (endOfFirstLine > 0) {
			String delimiter = numbers.substring(0, endOfFirstLine);
			if (!NumberUtils.isDigits(delimiter)) {
				numbers = numbers.substring(endOfFirstLine + 1);
				return stream(Splitter.on(delimiter).split(numbers)).mapToInt(Integer::parseInt).sum();
			}
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
