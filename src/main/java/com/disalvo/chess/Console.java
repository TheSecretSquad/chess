package com.disalvo.chess;

public interface Console {

	void printPieceTypeOfColor(final PieceType pieceType, final Color color);
	
	void printEmptyLightSquare();
	
	void printEmptyDarkSquare();

	void startNewRank();
}