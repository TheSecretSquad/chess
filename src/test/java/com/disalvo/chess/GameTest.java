package com.disalvo.chess;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

	private Game game;
	private Square square;
	private MovesReceiver movesReceiver = mock(MovesReceiver.class);
	private Board board = mock(Board.class);

	@Before
	public void setUp() throws Exception {
		square = anySquare();
		game = new Game(board, movesReceiver);
	}

	private Square anySquare() {
		return Square.A1;
	}

	@Test
	public void shouldSendMovesForSquareWhenSquareIsChosen() {
		game.chooseSquare(square);
		verify(board).sendMovesForTo(square, movesReceiver);
	}

	@Test
	public void shouldPrintTheBoardToTheConsoleWhenStarted() {
		game.start();
		verify(board).printToConsole();
	}
}