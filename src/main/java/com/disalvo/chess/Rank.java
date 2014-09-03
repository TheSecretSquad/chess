package com.disalvo.chess;

public enum Rank {
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8);

	private final int rankValue;

	Rank(final int rankValue) {
		this.rankValue = rankValue;
	}

	@Override
	public String toString() {
		return String.valueOf(rankValue);
	}
}