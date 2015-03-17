package com.disalvo.chess;

public interface PieceChoiceContextFactory {

	PieceTargeting createContext(final Square originSquare, final TargetSource targetSource, final MovesReceiver movesReceiver);
}