package com.disalvo.chess;

public class Rook extends ChessPiece {

	public Rook(final Color color) {
		super(PieceType.ROOK, color);
	}

	@Override
	protected Rook newPieceOfColor(Color color) {
		return new Rook(color);
	}
}