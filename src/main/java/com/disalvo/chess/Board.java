package com.disalvo.chess;

public interface Board {

	void sendMovesForTo(Square square, MovesOutput movesOutput);

	void printToConsole();
}