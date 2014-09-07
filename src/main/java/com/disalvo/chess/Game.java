package com.disalvo.chess;

public class Game {

	private final Board board;
	private final MovesReceiver movesOutput;

	public Game(final Board board, final MovesReceiver movesOutput) {
		this.board = board;
		this.movesOutput = movesOutput;
	}

	public void chooseSquare(final Square square) {
		board.sendMovesForTo(square, movesOutput);
	}

	public void start() {
		board.printToConsole();
	}
}