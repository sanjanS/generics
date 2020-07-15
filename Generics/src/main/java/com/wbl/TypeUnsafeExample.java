package com.wbl;

/**
 * This class is a type unsafe/non generic.
 */
public class TypeUnsafeExample {

	private static final int SIZE = 10;
	private static final int LENGTH_SIZE = 0;

	public String getConcatenatedUnsafeString(final int intValue, final String... values) {
		if (values == null || values.length <= LENGTH_SIZE) {
			throw new IllegalArgumentException("String array can't be null or empty");
		}
		CircularBuffer buffer = new CircularBuffer(SIZE);
		for (String element : values) {
			buffer.offer(element);
		}
		buffer.offer(intValue);
		return concatenate(buffer);
	}

	private static String concatenate(CircularBuffer buffer) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < buffer.size(); i++) {
			final String value = (String) buffer.poll();
			if (value != null) {
				result.append(value);
			}
		}
		return result.toString();
	}
}
