package com.wbl.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wbl.GenericCircularBuffer;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test class is used to test functions of GenericCircularBuffer class.
 */
public class GenericCircularBufferTest {

	private static GenericCircularBuffer<Integer> buffer;
	private static final int SIZE = 2;

	@BeforeMethod
	public void init() {
		buffer = new GenericCircularBuffer<>(SIZE);
	}

	@Test
	public void shouldOfferPollableElement() {
		assertThat(buffer.offer(1)).isTrue();
		assertThat(buffer.poll()).isEqualTo(Integer.valueOf(1));
	}

	@Test
	public void shouldNotOfferWhenBufferIsFull() {
		assertThat(buffer.offer(1)).isTrue();
		assertThat(buffer.offer(1)).isTrue();
		assertThat(buffer.offer(3)).isFalse();
	}

	@Test
	public void shouldNotPollWhenBufferIsEmpty() {
		assertThat(buffer.poll()).isNull();
	}

}
