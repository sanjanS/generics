package com.wbl;

/**
 * This class contains two functions to insert and remove.
 */
public class CircularBuffer {

	private final transient Object[] buffer;
	private static int readCursor;
	private static int writeCursor;

	public CircularBuffer(int size) {
		buffer = new Object[size];
	}

	public  boolean offer(Object value) {
		if (buffer[writeCursor] != null) {
			return false;
		}

		buffer[writeCursor] = value;
		writeCursor = next(writeCursor);
		return true;
	}

	public Object poll() {
		final Object value = buffer[readCursor];
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
