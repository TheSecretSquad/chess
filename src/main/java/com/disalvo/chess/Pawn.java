package com.disalvo.chess;

public class Pawn extends ChessPiece {

	public Pawn(final Color color) {
		super(ChessPieceType.PAWN, color);
	}

	@Override
	public void targetFromSquareWith(final Square originSquare, final MovesReceiver movesReceiver) {
		// TODO Auto-generated method stub
	}
}