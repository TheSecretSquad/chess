package com.disalvo.chess;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

	private Game game;
	private Square square;
	@Mock
	private MovesOutput movesOutput;
	@Mock
	private Board board;

	@Before
	public void setUp() throws Exception {
		square = anySquare();
		game = new Game(board, movesOutput);
	}

	private Square anySquare() {
		return Square.A1;
	}

	@Test
	public void shouldShowMovesFromSquareOnBoardToOutput() {
		game.showMovesFor(square);
		verify(board).showMovesForOn(square, movesOutput);
	}
}