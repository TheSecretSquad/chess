package com.disalvo.chess;

public class Pawn extends ChessPiece {

	public Pawn(final Color color, final PieceTargetting pieceTargetting) {
		super(ChessPieceType.PAWN, color, pieceTargetting);
	}

	@Override
	protected void targetFromSquareWithReceiverUsing(
			final Square originSquare, final MovesReceiver movesReceiver, final PieceTargetting pieceTargetting) {		
	}
}