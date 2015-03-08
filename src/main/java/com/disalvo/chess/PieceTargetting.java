package com.disalvo.chess;

public interface PieceTargetting {

	void targetForwardFromSquareAsColorWith(final Square originSquare, final Color color, final MovesReceiver movesReceiver);
}