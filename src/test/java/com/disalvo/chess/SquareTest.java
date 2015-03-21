package com.disalvo.chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SquareTest {

	@Test
	public void shouldHaveStringConversionEqualToEnumName() {
		assertEquals("A1", Square.A1.toString());
		assertEquals("H8", Square.H8.toString());
	}
}