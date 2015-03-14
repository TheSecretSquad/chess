package com.disalvo.chess;

public class Bishop extends ChessPiece {

	public Bishop(final Color color, final PieceTargetting pieceTargetting) {
		super(ChessPieceType.BISHOP, color, pieceTargetting);
	}

	@Override
	protected void targetFromSquareWithReceiverUsing(
			final Square originSquare, final MovesReceiver movesReceiver, final PieceTargetting pieceTargetting) {
		// TODO Auto-generated method stub
		
	}
}