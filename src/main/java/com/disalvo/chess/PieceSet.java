package com.disalvo.chess;

public interface PieceSet {
	
	void setupPieceTypeOfColorOnBoardAt(final PieceType pieceType, final Color color,
			final Board board, final Square... squares);
}