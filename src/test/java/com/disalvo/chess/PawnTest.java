package com.disalvo.chess;

import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PawnTest {

	private Pawn pawn;
	@Mock
	private Board board;
	
	@Before
	public void setUp() throws Exception {
		pawn = new Pawn(Color.LIGHT);
	}

	@Test
	public void shouldCreateNewPawnWhenCreatingNewPieceOnBoard() {
		pawn.newPieceOnBoardAt(board, Square.A1);
		verify(board).placePieceAt(isA(Pawn.class), eq(Square.A1));
	}
}