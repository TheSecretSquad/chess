package com.disalvo.chess;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

	private Game game;
    private Square square;
	private MovesOutput movesOutput = mock(MovesOutput.class);
	private Board board = mock(Board.class);

	@Before
	public void setUp() throws Exception {
        square = anySquare();
		game = new Game(board, movesOutput);
	}

    private Square anySquare() {
        return Square.A1;
    }

    @Test
	public void shouldShowMovesForSquareOnBoardOnOutput() {
		game.showMovesFor(square);
		verify(board).showMovesForOn(square, movesOutput);
	}
    
    @Test
    public void shouldPrintTheBoardToTheConsoleWhenStarted() {
    	game.start();
    	verify(board).printToConsole();
    }
}