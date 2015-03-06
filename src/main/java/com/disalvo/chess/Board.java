package com.disalvo.chess;

public interface Board {

	void chooseSquare(final Square square);

	void printToConsole();
	
	void setupAs(final ChessConfiguration chessConfiguration);

	void submitMove(final Square fromSquare, final Square toSquare);

	void placePieceAt(final Piece piece, final Square square);
}