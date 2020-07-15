package com.wbl;

/**
 * This class is a String generic type.
 */
public class StringCircularBuffer {

	private final transient String[] buffer;
	private static int readCursor;
	private static int writeCursor;

	public StringCircularBuffer(int size) {
		buffer = new String[size];
	}

	public boolean offer(String value) {
		if (buffer[writeCursor] != null) {
			return false;
		}

		buffer[writeCursor] = value;
		writeCursor = next(writeCursor);
		return true;
	}

	public String poll() {
		String value = buffer[readCursor];
		if (value != null) {
			buffer[readCursor] = null;
			readCursor = next(readCursor);
		}
		return value;
	}

	public int size() {
		return writeCursor;
	}

	private int next(int index) {
		return (index + 1) % buffer.length;
	}
}
