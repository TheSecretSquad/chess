package com.disalvo.chess;


public class Pawn extends ChessPiece {

	private boolean hasMoved = false;
	
	public Pawn(final Color color, final ChessPieceTargetingFactory chessPieceTargetingFactory) {
		super(ChessPieceType.PAWN, color, chessPieceTargetingFactory);
	}

	@Override
	protected void choose(final ChessPieceTargeting chessPieceTargeting) {
		targetForward(chessPieceTargeting);
		attackDiagonals(chessPieceTargeting);
	}

	private void targetForward(final ChessPieceTargeting chessPieceTargeting) {
		TargetingCount forwardTargetingCount = hasMoved ? new TargetingCount(1) : new TargetingCount(2);
		chessPieceTargeting.pathForward(forwardTargetingCount);
	}
	
	private void attackDiagonals(final ChessPieceTargeting chessPieceTargeting) {
		chessPieceTargeting.attackForwardRight();
		chessPieceTargeting.attackForwardLeft();
	}

	public void move() {
		hasMoved = true;
	}
}