package com.disalvo.chess;

public interface Board {

	void sendMovesForTo(Square square, MovesReceiver movesOutput);

	void printToConsole();
}