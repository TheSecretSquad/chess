package com.disalvo.chess;

public class Queen extends ChessPiece {

	public Queen(final Color color, final PieceTargetting pieceTargetting) {
		super(ChessPieceType.KING, color, pieceTargetting);
	}

	@Override
	protected void targetSteps(StepSelector stepSelector) {
		// TODO Auto-generated method stub
		
	}
}