package com.disalvo.chess;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileTest {

	@Test
	public void shouldHaveStringConversionEqualToEnumName() {
		assertEqualsFile("A", File.A);
		assertEquals("B", File.B.toString());
		assertEquals("C", File.C.toString());
		assertEquals("D", File.D.toString());
		assertEquals("E", File.E.toString());
		assertEquals("F", File.F.toString());
		assertEquals("G", File.G.toString());
		assertEquals("H", File.H.toString());
	}

    private void assertEqualsFile(String actual, File expected) {
        assertEquals(actual, expected.toString());
    }
}