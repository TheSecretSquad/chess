package com.disalvo.chess;

public interface PieceChoiceContextFactory {

	PieceTargetting createContext(final Square originSquare, final TargetSource targetSource, final MovesReceiver movesReceiver);
}