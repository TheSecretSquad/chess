package com.disalvo.chess;

public interface SquareProvider {

	void provideRanksInReverseTo(final SquareRankConsumer squareRankConsumer);
}