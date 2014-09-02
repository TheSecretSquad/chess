package main;

public class Game {
    
    private final Board board;
    private final MovesOutput movesOutput;
    
    public Game(final Board board, final MovesOutput movesOutput) {
	this.board = board;
	this.movesOutput = movesOutput;
    }

    public void showMovesFor(final Square square) {
	board.showMovesFor(square, movesOutput);
    }
}