package com.disalvo.chess;

public interface PieceTargetingFactory {

	ChessPieceTargeting create(final Square originSquare, final TargetSource targetSource, final MovesReceiver movesReceiver);
}