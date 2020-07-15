package com.wbl.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wbl.CircularBuffer;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test class is uses to test CircularBuffer's functions.
 */
public class CircularBufferTest {

	private static CircularBuffer buffer;
	private static final int SIZE = 2;

	@BeforeMethod
	public void init() {
		buffer = new CircularBuffer(SIZE);
	}

	@Test
	public void shouldOfferPollableElement() {
		assertThat(buffer.offer(1)).isTrue();
		assertThat(buffer.poll()).isEqualTo(1);
		assertThat(buffer.poll()).isNull();
	}

	@Test
	public void shouldNotOfferWhenBufferIsFull() {
		assertThat(buffer.offer(1)).isTrue();
		assertThat(buffer.offer(2)).isTrue();
		assertThat(buffer.offer(3)).isFalse();
	}

	@Test
	public void shouldNotPollWhenBufferIsEmpty() {
		assertThat(buffer.poll()).isNull();
	}

}
