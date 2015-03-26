package com.disalvo.chess;

public interface Board extends BoardSetup {

	void sendMovesForSquareTo(final Square square, final MovesReceiver movesReceiver);

	void printToConsole();
	
	void configureAs(final ChessConfiguration chessConfiguration);

	void submitMove(final Square fromSquare, final Square toSquare);
}