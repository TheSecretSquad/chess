package com.disalvo.chess;

public class King extends ChessPiece {

	public King(final Color color, final PieceTargetingFactory pieceTargetingFactory) {
		super(ChessPieceType.KING, color, pieceTargetingFactory);
	}

	@Override
	protected void choose(final PieceTargeting pieceTargeting) {
		// TODO Auto-generated method stub
		
	}
}