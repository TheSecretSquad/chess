package test;

import static org.mockito.Mockito.verify;
import main.Board;
import main.Game;
import main.MovesOutput;
import main.Square;

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
    private MovesOutput movesOutput;
    @Mock
    private Board board;
    
    @Before
    public void setUp() throws Exception {
	square = anySquare();
	game = new Game(board, movesOutput);
    }
    
    private Square anySquare()
    {
	return new Square(1, 1);
    }
    
    @Test
    public void shouldShowMovesFromSquareOnBoardToOutput() {
	game.showMovesFor(square);
	verify(board).showMovesFor(square, movesOutput);
    }
}