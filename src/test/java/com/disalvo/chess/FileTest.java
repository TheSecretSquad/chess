package com.disalvo.chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FileTest {

	@Test
	public void shouldHaveStringValueEqualToEnumName() {
		assertEquals("A", File.A.toString());
		assertEquals("B", File.B.toString());
		assertEquals("C", File.C.toString());
		assertEquals("D", File.D.toString());
		assertEquals("E", File.E.toString());
		assertEquals("F", File.F.toString());
		assertEquals("G", File.G.toString());
		assertEquals("H", File.H.toString());
	}
}