package com.disalvo.chess;

public interface ReverseRankSquareProvider {

	void provideSquaresTo(final ByRankSquareConsumer squareRankConsumer);
}