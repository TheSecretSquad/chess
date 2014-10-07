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
	private MovesReceiver movesReceiver;
	@Mock
	private Board board;
	@Mock
	private StartingPieceConfiguration startingPieceConfiguration;

	@Before
	public void setUp() throws Exception {
		square = anySquare();
		game = new Game(board, startingPieceConfiguration, movesReceiver);
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
	
	@Test
	public void shouldSetupPiecesOnTheBoardWhenStarted() {
		game.start();
		verify(startingPieceConfiguration).setup(board);
	}
}