package com.disalvo.chess;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

	private Game game;
	private Square square;
	@Mock
	private Board board;
	@Mock
	private ChessConfiguration chessConfiguration;
	@Mock
	private MovesReceiver movesReceiver;

	@Before
	public void setUp() throws Exception {
		square = anySquare();
		game = new Game(board, movesReceiver, chessConfiguration);
	}

	private Square anySquare() {
		return Square.A1;
	}

	@Test
	public void shouldSendMovesWhenSquareIsChosen() {
		game.chooseSquare(square);
		verify(board).sendMovesForSquareTo(square, movesReceiver);
	}

	@Test
	public void shouldPrintTheBoardToTheConsoleWhenStarted() {
		game.start();
		verify(board).printToConsole();
	}
	
	@Test
	public void shouldConfigureTheBoardWhenStarted() {
		game.start();
		verify(board).configureAs(chessConfiguration);
	}
}