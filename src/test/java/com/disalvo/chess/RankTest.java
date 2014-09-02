package com.disalvo.chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.disalvo.chess.Square.Rank;

public class RankTest {

	@Test
	public void shouldHaveStringValueEqualToNumericValue() {
		assertEquals("1", Rank.ONE.toString());
		assertEquals("2", Rank.TWO.toString());
		assertEquals("3", Rank.THREE.toString());
		assertEquals("4", Rank.FOUR.toString());
		assertEquals("5", Rank.FIVE.toString());
		assertEquals("6", Rank.SIX.toString());
		assertEquals("7", Rank.SEVEN.toString());
		assertEquals("8", Rank.EIGHT.toString());
	}
}