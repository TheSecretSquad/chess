package com.disalvo.chess;

public interface Board {

	void sendMovesForTo(final Square square, final MovesReceiver movesReceiver);

	void printToConsole();
	
	void setupAs(final ChessConfiguration chessConfiguration);

	void move(final Square fromSquare, final Square toSquare);

	void placePieceAt(final Piece piece, final Square square);
}