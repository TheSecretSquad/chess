package com.disalvo.chess;


public class Pawn extends ChessPiece {

	public Pawn(final Color color, final PieceTargetingFactory pieceTargetingFactory) {
		super(ChessPieceType.PAWN, color, pieceTargetingFactory);
	}

	@Override
	protected void choose(final PieceTargeting pieceTargeting) {
		pieceTargeting.path(RankDirection.FORWARD, new TargetingCount(2), new TargetingCount(1));
	}
}