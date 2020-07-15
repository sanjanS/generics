package com.wbl.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wbl.TypeUnsafeExample;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * This test class is used to test functions of TypeUnsafe class.
 */
public class TypeUnsafeExampleTest {

	private static TypeUnsafeExample typeUnsafeExample;

	private static final String VALUE_1 = "a";
	private static final String VALUE_2 = "bc";
	private static final String VALUE_3 = "d";

	private static final int INT_VALUE = 1;

	@BeforeTest
	public void init() {
		typeUnsafeExample = new TypeUnsafeExample();
	}

	@Test
	public void testConcatenatedUnsafeString() {
		String[] strings = { VALUE_1, VALUE_2, VALUE_3 };
		assertThatExceptionOfType(ClassCastException.class)
				.isThrownBy(() -> typeUnsafeExample.getConcatenatedUnsafeString(INT_VALUE, strings));
	}

	@Test
	public void testConcatenatedUnsafeStringWithNull() {
		String[] strings = null;
		assertThatIllegalArgumentException()
				.isThrownBy(() -> typeUnsafeExample.getConcatenatedUnsafeString(INT_VALUE, strings));
	}

	@Test
	public void testConcatenatedUnsafeStringWithEmpty() {
		String[] strings = {};
		assertThatIllegalArgumentException()
				.isThrownBy(() -> typeUnsafeExample.getConcatenatedUnsafeString(INT_VALUE, strings));
	}
}
