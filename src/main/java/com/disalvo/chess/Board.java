package com.disalvo.chess;

public interface Board extends BoardSetup {

	void chooseSquare(final Square square);

	void printToConsole();
	
	void configureAs(final ChessConfiguration chessConfiguration);

	void submitMove(final Square fromSquare, final Square toSquare);
}