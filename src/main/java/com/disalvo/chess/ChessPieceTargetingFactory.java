package com.disalvo.chess;

public interface ChessPieceTargetingFactory {

	ChessPieceTargeting create(final Square originSquare, final TargetSource targetSource, final MovesReceiver movesReceiver);
}