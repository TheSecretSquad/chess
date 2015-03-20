package com.disalvo.chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnicodeStringPieceTest {

	@Test
	public void shouldHaveStringConversionEqualToUnicodeSymbol() {
		assertEquals("\u2657", UnicodeStringPiece.LIGHT_BISHOP.toString());
		assertEquals("\u2654", UnicodeStringPiece.LIGHT_KING.toString());
		assertEquals("\u2658", UnicodeStringPiece.LIGHT_KNIGHT.toString());
		assertEquals("\u2659", UnicodeStringPiece.LIGHT_PAWN.toString());
		assertEquals("\u2655", UnicodeStringPiece.LIGHT_QUEEN.toString());
		assertEquals("\u2656", UnicodeStringPiece.LIGHT_ROOK.toString());
		assertEquals("\u265D", UnicodeStringPiece.DARK_BISHOP.toString());
		assertEquals("\u265A", UnicodeStringPiece.DARK_KING.toString());
		assertEquals("\u265E", UnicodeStringPiece.DARK_KNIGHT.toString());
		assertEquals("\u265F", UnicodeStringPiece.DARK_PAWN.toString());
		assertEquals("\u265B", UnicodeStringPiece.DARK_QUEEN.toString());
		assertEquals("\u265C", UnicodeStringPiece.DARK_ROOK.toString());
	}
}