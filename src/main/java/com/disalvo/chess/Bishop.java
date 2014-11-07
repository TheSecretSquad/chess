package com.disalvo.chess;

public class Bishop extends ChessPiece {

	public Bishop(final Color color) {
		super(PieceType.BISHOP, color);
	}

	@Override
	protected Bishop newPieceOfColor(Color color) {
		return new Bishop(color);
	}
}