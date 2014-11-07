package com.disalvo.chess;

public enum UnicodeStringPiece {
	LIGHT_BISHOP("\u2657"),
	LIGHT_KING("\u2654"),
	LIGHT_KNIGHT("\u2658"),
	LIGHT_PAWN("\u2659"),
	LIGHT_QUEEN("\u2655"),
	LIGHT_ROOK("\u2656"),
	DARK_BISHOP("\u265D"),
	DARK_KING("\u265A"),
	DARK_KNIGHT("\u265E"),
	DARK_PAWN("\u265F"),
	DARK_QUEEN("\u265B"),
	DARK_ROOK("\u265C");
		
	private UnicodeStringPiece(final String stringValue) {
		this.stringValue = stringValue;
	}
	
	private final String stringValue;
	
	@Override
	public String toString() {
		return stringValue;
	}
}