package com.disalvo.chess;

public class Pawn extends ChessPiece {

	public Pawn(final Color color) {
		super(PieceType.PAWN, color);
	}

	@Override
	protected Pawn newPieceOfColor(Color color) {
		return new Pawn(color);
	}
}