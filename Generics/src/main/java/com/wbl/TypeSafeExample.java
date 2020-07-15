package com.wbl;

/**
 * This class is a typesafe class which only takes string as input type.
 */
public class TypeSafeExample {

	private static final int LENGTH_SIZE = 0;
	private static final int SIZE = 10;

	public String getConcatenatedString(final String... values) {
		if (values == null || values.length <= LENGTH_SIZE) {
			throw new IllegalArgumentException("String array can't be null or empty");
		}
		StringCircularBuffer buffer = new StringCircularBuffer(SIZE);
		for (String element : values) {
			buffer.offer(element);
		}
		return concatenate(buffer);
	}

	private static String concatenate(StringCircularBuffer buffer) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < buffer.size(); i++) {
			final String value = buffer.poll();
			if (value != null) {
				result.append(value);
			}
		}
		return result.toString();
	}
}
