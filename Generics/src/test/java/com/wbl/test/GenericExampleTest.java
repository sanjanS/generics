package com.wbl.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wbl.GenericExample;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * This test class is used to test functions of GenericExample class.
 */
public class GenericExampleTest {

	private static GenericExample genericExample;

	private static final String VALUE_1 = "a";
	private static final String VALUE_2 = "bc";
	private static final String VALUE_3 = "d";

	@BeforeTest
	public void init() {
		genericExample = new GenericExample();
	}

	@Test
	public void testConcatenatedString() {
		String[] strings = { VALUE_1, VALUE_2, VALUE_3 };
		assertThat(genericExample.getConcatenateString(strings)).isEqualTo("abcd");
	}

	@Test
	public void testConcatenatedStringWithNull() {
		String[] strings = null;
		assertThatIllegalArgumentException().isThrownBy(() -> genericExample.getConcatenateString(strings));
	}

	@Test
	public void testConcatenatedStringWithEmpty() {
		String[] strings = {};
		assertThatIllegalArgumentException().isThrownBy(() -> genericExample.getConcatenateString(strings));
	}
}
