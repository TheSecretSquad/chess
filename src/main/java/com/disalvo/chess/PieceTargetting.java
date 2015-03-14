package com.disalvo.chess;

public interface PieceTargetting {

	void targetForwardFromSquareWithTargetSourceTo(final Square originSquare, final TargetSource targetSource, final MovesReceiver movesReceiver);
}