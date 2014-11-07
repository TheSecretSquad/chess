package com.disalvo.chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mock;

public class SquareTest {

	@Mock
	private SquareRankConsumer squareRankConsumer;
	
	@Test
	public void shouldHaveStringConversionEqualToEnumName() {
		assertEquals("A1", Square.A1.toString());
		assertEquals("H8", Square.H8.toString());
	}
}