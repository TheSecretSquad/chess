package com.disalvo.chess;

public interface PieceTargetingFactory {

	PieceTargeting create(final Square originSquare, final Color color, final TargetSource targetSource);
}