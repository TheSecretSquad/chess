package com.disalvo.chess;

public class Pawn extends ChessPiece {

	public Pawn(final Color color, final PieceTargetting pieceTargetting) {
		super(ChessPieceType.PAWN, color, pieceTargetting);
	}

	@Override
	protected void targetSteps(final StepSelector stepSelector) {
		stepSelector.forward();
	}
}