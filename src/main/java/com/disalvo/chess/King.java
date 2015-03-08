package com.disalvo.chess;

public class King extends ChessPiece {

	public King(final Color color, final PieceTargetting pieceTargetting) {
		super(ChessPieceType.KING, color, pieceTargetting);
	}

	@Override
	protected void targetSteps(StepSelector stepSelector) {
		// TODO Auto-generated method stub
		
	}
}