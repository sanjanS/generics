package com.wbl;

/**
 * This generic class is used to insert and remove elements.
 * 
 * @param <T> tag.
 */
public class GenericCircularBuffer<T> {

	private final transient T[] buffer;
	private static int readCursor;
	private static int writeCursor;

	@SuppressWarnings("unchecked")
	public GenericCircularBuffer(int size) {
		buffer = (T[]) new Object[size];
	}

	public boolean offer(T value) {
		if (buffer[writeCursor] != null) {
			return false;
		}
		buffer[writeCursor] = value;
		writeCursor = next(writeCursor);
		return true;
	}

	@SuppressWarnings("unchecked")
	public T poll() {
		T value = buffer[readCursor];
		if (value != null) {
			buffer[readCursor] = null;
			readCursor = next(readCursor);
		}
		return value;
	}

	private int next(int index) {
		return (index + 1) % buffer.length;
	}

	public int size() {
		return writeCursor;
	}
}
