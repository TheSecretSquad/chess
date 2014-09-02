package com.disalvo.chess;

public enum Square {

	A1(File.A, Rank.ONE),
	A2(File.A, Rank.TWO),
	A3(File.A, Rank.THREE),
	A4(File.A, Rank.FOUR),
	A5(File.A, Rank.FIVE),
	A6(File.A, Rank.SIX),
	A7(File.A, Rank.SEVEN),
	A8(File.A, Rank.EIGHT),
	B1(File.B, Rank.ONE),
	B2(File.B, Rank.TWO),
	B3(File.B, Rank.THREE),
	B4(File.B, Rank.FOUR),
	B5(File.B, Rank.FIVE),
	B6(File.B, Rank.SIX),
	B7(File.B, Rank.SEVEN),
	B8(File.B, Rank.EIGHT),
	C1(File.C, Rank.ONE),
	C2(File.C, Rank.TWO),
	C3(File.C, Rank.THREE),
	C4(File.C, Rank.FOUR),
	C5(File.C, Rank.FIVE),
	C6(File.C, Rank.SIX),
	C7(File.C, Rank.SEVEN),
	C8(File.C, Rank.EIGHT),
	D1(File.D, Rank.ONE),
	D2(File.D, Rank.TWO),
	D3(File.D, Rank.THREE),
	D4(File.D, Rank.FOUR),
	D5(File.D, Rank.FIVE),
	D6(File.D, Rank.SIX),
	D7(File.D, Rank.SEVEN),
	D8(File.D, Rank.EIGHT),
	E1(File.E, Rank.ONE),
	E2(File.E, Rank.TWO),
	E3(File.E, Rank.THREE),
	E4(File.E, Rank.FOUR),
	E5(File.E, Rank.FIVE),
	E6(File.E, Rank.SIX),
	E7(File.E, Rank.SEVEN),
	E8(File.E, Rank.EIGHT),
	F1(File.F, Rank.ONE),
	F2(File.F, Rank.TWO),
	F3(File.F, Rank.THREE),
	F4(File.F, Rank.FOUR),
	F5(File.F, Rank.FIVE),
	F6(File.F, Rank.SIX),
	F7(File.F, Rank.SEVEN),
	F8(File.F, Rank.EIGHT),
	G1(File.G, Rank.ONE),
	G2(File.G, Rank.TWO),
	G3(File.G, Rank.THREE),
	G4(File.G, Rank.FOUR),
	G5(File.G, Rank.FIVE),
	G6(File.G, Rank.SIX),
	G7(File.G, Rank.SEVEN),
	G8(File.G, Rank.EIGHT),
	H1(File.H, Rank.ONE),
	H2(File.H, Rank.TWO),
	H3(File.H, Rank.THREE),
	H4(File.H, Rank.FOUR),
	H5(File.H, Rank.FIVE),
	H6(File.H, Rank.SIX),
	H7(File.H, Rank.SEVEN),
	H8(File.H, Rank.EIGHT);

	private final String position;

	Square(final File file, final Rank rank) {
		position = file.toString() + rank.toString();
	}

	public enum File {
		A,
		B,
		C,
		D,
		E,
		F,
		G,
		H;
	}

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
}