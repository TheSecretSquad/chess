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
	private ChessConfiguration chessConfiguration;

	@Before
	public void setUp() throws Exception {
		square = anySquare();
		game = new Game(board, chessConfiguration, movesReceiver);
	}

	private Square anySquare() {
		return Square.A1;
	}

	@Test
	public void shouldChooseSquareOnBoardWhenSquareIsChosen() {
		game.chooseSquare(square);
		verify(board).chooseSquare(square);
	}

	@Test
	public void shouldPrintTheBoardToTheConsoleWhenStarted() {
		game.start();
		verify(board).printToConsole();
	}
	
	@Test
	public void shouldSetupPiecesOnTheBoardWhenStarted() {
		game.start();
		verify(board).setupAs(chessConfiguration);
	}
	
	@Test
	public void shouldSubmitMoveToBoardWhenMoveSubmitted() {
		Square from = anySquare();
		Square to = anySquare();
		game.submitMove(from, to);
		verify(board).submitMove(from, to);
	}
}