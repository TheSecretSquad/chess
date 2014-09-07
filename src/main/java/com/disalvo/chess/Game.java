package com.disalvo.chess;

public class Game {

	private final Board board;
	private final MovesReceiver movesReceiver;

	public Game(final Board board, final MovesReceiver movesReceiver) {
		this.board = board;
		this.movesReceiver = movesReceiver;
	}

	public void chooseSquare(final Square square) {
		board.sendMovesForTo(square, movesReceiver);
	}

	public void start() {
		board.printToConsole();
	}
}