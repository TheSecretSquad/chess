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
public class KingTest {

	private King king;
	@Mock
	private Board board;
	
	@Before
	public void setUp() throws Exception {
		king = new King(Color.LIGHT);
	}

	private Square anySquare() {
		return Square.A1;
	}
	
	@Test
	public void shouldCreateNewKingWhenCreatingNewPieceOnBoard() {
		king.newPieceOnBoardAt(board, anySquare());
		verify(board).placePieceAt(isA(King.class), eq(anySquare()));
	}
}