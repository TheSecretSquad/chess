package com.disalvo.chess;

public interface SquareRankConsumer {
	
	void giveSquare(final Square square);
	
	void endRank();
}