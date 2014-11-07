package com.disalvo.chess;

public class King extends ChessPiece {

	public King(final Color color) {
		super(PieceType.KING, color);
	}

	@Override
	protected King newPieceOfColor(Color color) {
		return new King(color);
	}
}