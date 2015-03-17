package com.disalvo.chess;

public interface Piece extends TargetSource {

	void printTo(final Console console);

	void choose(final PieceTargeting pieceTargeting);
}