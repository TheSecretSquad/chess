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

	@Before
	public void setUp() throws Exception {
		square = anySquare();
		game = new Game(board);
	}

	private Square anySquare() {
		return Square.A1;
	}

	@Test
	public void shouldChooseSquareOnTheBoardWhenSquareIsChosen() {
		game.chooseSquare(square);
		verify(board).chooseSquare(square);
	}

	@Test
	public void shouldPrepareTheBoardWhenStarted() {
		game.start();
		verify(board).prepareToPlay();
	}
}