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
		chessPiece = new ChessPiece(PieceType.PAWN, Color.LIGHT) {

			@Override
			protected ChessPiece newPieceOfColor(Color color) {
				return null;
			}
		};
	}

	@Test
	public void shouldPrintWithGivenPieceTypeAndColorWhenPrintingToConsole() {
		chessPiece.printTo(console);
		verify(console).printPieceTypeOfColor(PieceType.PAWN, Color.LIGHT);
	}
}