package com.disalvo.chess;

public interface Console {

	void printPieceTypeOfColor(final ChessPieceType pieceType, final Color color);
	
	void printEmptyLightSquare();
	
	void printEmptyDarkSquare();

	void startNewRank();
}