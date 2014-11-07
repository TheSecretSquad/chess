package com.disalvo.chess;

public class Knight extends ChessPiece {

	public Knight(final Color color) {
		super(PieceType.KNIGHT, color);
	}

	@Override
	protected Knight newPieceOfColor(Color color) {
		return new Knight(color);
	}
}