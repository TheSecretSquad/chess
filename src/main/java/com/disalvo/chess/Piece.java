package com.disalvo.chess;

public interface Piece {

	void printTo(final Console console);

	void targetFromSquareWith(final Square originSquare, final MovesReceiver movesReceiver);
}