package com.disalvo.chess;

public class Queen extends ChessPiece {

	public Queen(final Color color, final PieceTargetingFactory pieceTargetingFactory) {
		super(ChessPieceType.KING, color, pieceTargetingFactory);
	}

	@Override
	protected void choose(final PieceTargeting pieceTargeting) {
		// TODO Auto-generated method stub
		
	}
}