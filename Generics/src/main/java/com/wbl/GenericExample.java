package com.wbl;

/**
 * This is a generic class which concatenates string only.
 */
public class GenericExample {

	private static final int SIZE = 10;
	private static final int LENGTH_SIZE = 0;

	public String getConcatenateString(final String... values) {
		if (values == null || values.length <= LENGTH_SIZE) {
			throw new IllegalArgumentException("String array can't be null or empty");
		}
		GenericCircularBuffer<String> buffer = new GenericCircularBuffer<String>(SIZE);
		for (String element : values) {
			buffer.offer(element);
		}
		return concatenate(buffer);
	}

	private static String concatenate(GenericCircularBuffer<String> buffer) {
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
