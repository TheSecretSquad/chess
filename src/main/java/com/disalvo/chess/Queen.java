package com.disalvo.chess;

public class Queen extends ChessPiece {

	public Queen(final Color color) {
		super(PieceType.QUEEN, color);
	}

	@Override
	protected Queen newPieceOfColor(Color color) {
		return new Queen(color);
	}
}