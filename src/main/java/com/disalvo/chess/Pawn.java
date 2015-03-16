package com.disalvo.chess;

public class Pawn extends ChessPiece {

	public Pawn(final Color color) {
		super(ChessPieceType.PAWN, color);
	}

	@Override
	public void choose(final PieceTargetting pieceTargetting) {
		pieceTargetting.forward();
	}
}