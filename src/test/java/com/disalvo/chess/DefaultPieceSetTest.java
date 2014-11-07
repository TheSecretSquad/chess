package com.disalvo.chess;
import static org.mockito.Mockito.verify;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultPieceSetTest {

	private DefaultPieceSet defaultPieceSet;
	@Mock
	private Board board;
	@Mock
	private PiecePrototype piecePrototype;
	
	@Before
	public void setUp() throws Exception {
		defaultPieceSet = new DefaultPieceSet();
		defaultPieceSet.registerPieceTypeOfColorWith(PieceType.PAWN, Color.LIGHT, piecePrototype);
	}

	private void verifyNewPieceCreated(final Square... squares) {
		Arrays.asList(squares).forEach((Square s) -> {
			verify(piecePrototype).newPieceOnBoardAt(board, Square.A1);
		});
	}
	
	@Test
	public void shouldCreateRegisteredPieceOnBoardAtGivenSquare() {
		defaultPieceSet.setupPieceTypeOfColorOnBoardAt(PieceType.PAWN, Color.LIGHT, board, Square.A1);
		verifyNewPieceCreated(Square.A1);
	}
	
	@Test
	public void shouldCreateRegisteredPieceOnBoardAtGivenSquares() {
		defaultPieceSet.setupPieceTypeOfColorOnBoardAt(PieceType.PAWN, Color.LIGHT, board, Square.A1, Square.A2);
		verifyNewPieceCreated(Square.A1, Square.A2);
	}
}