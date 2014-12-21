package com.disalvo.chess;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultBoardConsolePrinterTest {

	private DefaultBoardConsolePrinter defaultBoardConsolePrinter;
	@Mock
	private Console console;
	@Mock
	private SquareProvider squareProvider;
	@Mock
	private PieceProvider pieceProvider;
	@Mock
	private Piece piece;
	
	private SquareProvider makeSquareProviderOfA1() {
		return new SquareProvider() {
			@Override
			public void provideRanksInReverseTo(final SquareRankConsumer squareRankConsumer) {
				squareRankConsumer.giveSquare(Square.A1);
			}
		};
	}
	
	private SquareProvider makeSquareProviderOfFirstRank() {
		return new SquareProvider() {
			@Override
			public void provideRanksInReverseTo(final SquareRankConsumer squareRankConsumer) {
				squareRankConsumer.giveSquare(Square.A1);
				squareRankConsumer.giveSquare(Square.B1);
				squareRankConsumer.giveSquare(Square.C1);
				squareRankConsumer.giveSquare(Square.D1);
				squareRankConsumer.giveSquare(Square.E1);
				squareRankConsumer.giveSquare(Square.F1);
				squareRankConsumer.giveSquare(Square.G1);
				squareRankConsumer.giveSquare(Square.H1);
			}
		};
	}
	
	private PieceProvider makePieceProviderOfAnyPieceAtA1() {
		return new PieceProvider() {
			@Override
			public void providePieceAtSquareTo(final Square square, final SquarePieceConsumer pieceConsumer) {
				if(square.equals(Square.A1))
					pieceConsumer.givePiece(piece);
			}
		};
	}
	
	private PieceProvider makePieceProviderOfNoPieces() {
		return new PieceProvider() {
			@Override
			public void providePieceAtSquareTo(final Square square, final SquarePieceConsumer pieceConsumer) {
				pieceConsumer.noPiece();
			}
		};
	}

	private void setupForEmptySquareTest() {
		DefaultBoardConsolePrinter defaultBoardConsolePrinter = new DefaultBoardConsolePrinter(console, makeSquareProviderOfFirstRank());
		defaultBoardConsolePrinter.printFrom(makePieceProviderOfNoPieces());
	}
	
	@Before
	public void setUp() throws Exception {
		defaultBoardConsolePrinter = new DefaultBoardConsolePrinter(console, squareProvider);
	}

	@Test
	public void shouldProvideSquaresInReverseRankOrderToSquarePrinterWhenPrinting() {
		defaultBoardConsolePrinter.printFrom(pieceProvider);
		verify(squareProvider).provideRanksInReverseTo(isA(SquareRankConsumer.class));
	}
	
	@Test
	public void shouldPrintPieceToConsoleWhenPrinting() {
		DefaultBoardConsolePrinter defaultBoardConsolePrinter = new DefaultBoardConsolePrinter(console, makeSquareProviderOfA1());
		defaultBoardConsolePrinter.printFrom(makePieceProviderOfAnyPieceAtA1());
		verify(piece).printTo(console);
	}
	
	@Test
	public void shouldCorrectlyPrintDarkEmptySquaresToConsoleIfNoPieceWhenPrinting() {
		setupForEmptySquareTest();
		verify(console, times(4)).printEmptyDarkSquare();
	}
	
	@Test
	public void shouldCorrectlyPrintLightEmptySquaresToConsoleIfNoPieceWhenPrinting() {
		setupForEmptySquareTest();
		verify(console, times(4)).printEmptyLightSquare();
	}
}