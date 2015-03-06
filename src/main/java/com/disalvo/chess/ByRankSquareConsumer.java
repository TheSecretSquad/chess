package com.disalvo.chess;

public interface ByRankSquareConsumer {
	
	void giveSquare(final Square square);
	
	void endRank();
}