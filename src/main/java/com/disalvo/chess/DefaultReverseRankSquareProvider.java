package com.disalvo.chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DefaultReverseRankSquareProvider implements ReverseRankSquareProvider {

	private List<Square> reverseRankArrangement = new ArrayList<>();

	public DefaultReverseRankSquareProvider() {
		reverseRankArrangement.add(Square.A8); reverseRankArrangement.add(Square.B8); reverseRankArrangement.add(Square.C8);
		reverseRankArrangement.add(Square.D8); reverseRankArrangement.add(Square.E8); reverseRankArrangement.add(Square.F8);
		reverseRankArrangement.add(Square.G8); reverseRankArrangement.add(Square.H8);
		reverseRankArrangement.add(Square.A7); reverseRankArrangement.add(Square.B7); reverseRankArrangement.add(Square.C7);
		reverseRankArrangement.add(Square.D7); reverseRankArrangement.add(Square.E7); reverseRankArrangement.add(Square.F7);
		reverseRankArrangement.add(Square.G7); reverseRankArrangement.add(Square.H7);
		reverseRankArrangement.add(Square.A6); reverseRankArrangement.add(Square.B6); reverseRankArrangement.add(Square.C6);
		reverseRankArrangement.add(Square.D6); reverseRankArrangement.add(Square.E6); reverseRankArrangement.add(Square.F6);
		reverseRankArrangement.add(Square.G6); reverseRankArrangement.add(Square.H6);
		reverseRankArrangement.add(Square.A5); reverseRankArrangement.add(Square.B5); reverseRankArrangement.add(Square.C5);
		reverseRankArrangement.add(Square.D5); reverseRankArrangement.add(Square.E5); reverseRankArrangement.add(Square.F5);
		reverseRankArrangement.add(Square.G5); reverseRankArrangement.add(Square.H5);
		reverseRankArrangement.add(Square.A4); reverseRankArrangement.add(Square.B4); reverseRankArrangement.add(Square.C4);
		reverseRankArrangement.add(Square.D4); reverseRankArrangement.add(Square.E4); reverseRankArrangement.add(Square.F4);
		reverseRankArrangement.add(Square.G4); reverseRankArrangement.add(Square.H4);
		reverseRankArrangement.add(Square.A3); reverseRankArrangement.add(Square.B3); reverseRankArrangement.add(Square.C3);
		reverseRankArrangement.add(Square.D3); reverseRankArrangement.add(Square.E3); reverseRankArrangement.add(Square.F3);
		reverseRankArrangement.add(Square.G3); reverseRankArrangement.add(Square.H3);
		reverseRankArrangement.add(Square.A2); reverseRankArrangement.add(Square.B2); reverseRankArrangement.add(Square.C2);
		reverseRankArrangement.add(Square.D2); reverseRankArrangement.add(Square.E2); reverseRankArrangement.add(Square.F2);
		reverseRankArrangement.add(Square.G2); reverseRankArrangement.add(Square.H2);
		reverseRankArrangement.add(Square.A1); reverseRankArrangement.add(Square.B1); reverseRankArrangement.add(Square.C1);
		reverseRankArrangement.add(Square.D1); reverseRankArrangement.add(Square.E1); reverseRankArrangement.add(Square.F1);
		reverseRankArrangement.add(Square.G1); reverseRankArrangement.add(Square.H1);
	}
	
	public void provideSquaresTo(final ByRankSquareConsumer squareRankConsumer) {
		IntStream.rangeClosed(1, 64).forEachOrdered((int squareNumber) -> {
			provideSquareTo(squareRankConsumer, squareNumber);
		});
	}

	private void provideSquareTo(final ByRankSquareConsumer squareRankConsumer, final int squareNumber) {
		squareRankConsumer.giveSquare(square(squareNumber));
		if(isRankEnd(squareNumber))
			squareRankConsumer.endRank();
	}

	private Square square(final int squareNumber) {
		return reverseRankArrangement.get(squareNumber - 1);
	}
	
	private boolean isRankEnd(final int squareNumber) {
		return squareNumber % 8 == 0;
	}
}