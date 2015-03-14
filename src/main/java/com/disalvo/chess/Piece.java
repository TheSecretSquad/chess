package com.disalvo.chess;

public interface Piece extends TargetSource {

	void printTo(final Console console);

	void targetFromSquareTo(final Square originSquare, final MovesReceiver movesReceiver);
}