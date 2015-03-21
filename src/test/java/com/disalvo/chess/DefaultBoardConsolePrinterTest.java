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
	private ReverseRankSquareProvider squareProvider;
	@Mock
	private PieceAtSquareProvider pieceProvider;
	@Mock
	private Piece piece;
	
	private ReverseRankSquareProvider makeSquareProviderOfA1() {
		return new ReverseRankSquareProvider() {
			@Override
			public void provideSquaresTo(final ByRankSquareConsumer squareRankConsumer) {
				squareRankConsumer.giveSquare(Square.A1);
			}
		};
	}
	
	private ReverseRankSquareProvider makeSquareProviderOfFirstRank() {
		return new ReverseRankSquareProvider() {
			@Override
			public void provideSquaresTo(final ByRankSquareConsumer squareRankConsumer) {
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
	
	private PieceAtSquareProvider makePieceProviderOfAnyPieceAtA1() {
		return new PieceAtSquareProvider() {
			@Override
			public void providePieceAtSquareTo(final Square square, final PieceAtSquareConsumer pieceConsumer) {
				if(square.equals(Square.A1))
					pieceConsumer.givePiece(piece);
			}
		};
	}
	
	private PieceAtSquareProvider makePieceProviderOfNoPieces() {
		return new PieceAtSquareProvider() {
			@Override
			public void providePieceAtSquareTo(final Square square, final PieceAtSquareConsumer pieceConsumer) {
				pieceConsumer.noPiece();
			}
		};
	}

	private void setupForEmptySquareTest() {
		DefaultBoardConsolePrinter defaultBoardConsolePrinter = new DefaultBoardConsolePrinter(console, makeSquareProviderOfFirstRank());
		defaultBoardConsolePrinter.printFrom(makePieceProviderOfNoPieces());
	}
	
	// Tests
	
	@Before
	public void setUp() throws Exception {
		defaultBoardConsolePrinter = new DefaultBoardConsolePrinter(console, squareProvider);
	}

	@Test
	public void shouldProvideSquaresToSquareConsumerWhenPrinting() {
		defaultBoardConsolePrinter.printFrom(pieceProvider);
		verify(squareProvider).provideSquaresTo(isA(ByRankSquareConsumer.class));
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