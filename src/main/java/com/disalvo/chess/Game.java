package com.disalvo.chess;

public class Game {

	private final Board board;
	private final MovesOutput movesOutput;

	public Game(final Board board, final MovesOutput movesOutput) {
		this.board = board;
		this.movesOutput = movesOutput;
	}

	public void chooseSquare(final Square square) {
		board.showMovesForOn(square, movesOutput);
	}

	public void start() {
		board.printToConsole();
	}
}