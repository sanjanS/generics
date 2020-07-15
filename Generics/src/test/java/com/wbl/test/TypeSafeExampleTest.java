package com.wbl.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wbl.TypeSafeExample;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * This test class is used to test functions of TypeSafeExample class.
 */
public class TypeSafeExampleTest {

	private static TypeSafeExample typeSafeExample;

	private static final String VALUE_1 = "a";
	private static final String VALUE_2 = "bc";
	private static final String VALUE_3 = "d";

	@BeforeTest
	public void init() {
		typeSafeExample = new TypeSafeExample();
	}

	@Test
	public void testConcatenatedString() {
		String[] strings = { VALUE_1, VALUE_2, VALUE_3 };
		assertThat(typeSafeExample.getConcatenatedString(strings)).isEqualTo("abcd");
	}

	@Test
	public void testConcatenatedStringWithNull() {
		String[] strings = null;
		assertThatIllegalArgumentException().isThrownBy(() -> typeSafeExample.getConcatenatedString(strings));
	}

	@Test
	public void testConcatenatedStringWithEmpty() {
		String[] strings = {};
		assertThatIllegalArgumentException().isThrownBy(() -> typeSafeExample.getConcatenatedString(strings));
	}
}
