package com.disalvo.chess;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ChessPieceTest {

	private ChessPiece chessPiece;
	@Mock
	private Console console;
	@Mock
	private Board board;
	
	@Before
	public void setUp() throws Exception {
		chessPiece = new ChessPiece(ChessPieceType.PAWN, Color.LIGHT) {

			@Override
			public void targetFromSquareWith(Square originSquare, MovesReceiver movesReceiver) {
				// Abstract method tested in derived types
			}
		};
	}

	@Test
	public void shouldPrintWithGivenPieceTypeAndColorWhenPrintingToConsole() {
		chessPiece.printTo(console);
		verify(console).printPieceTypeOfColor(ChessPieceType.PAWN, Color.LIGHT);
	}
}