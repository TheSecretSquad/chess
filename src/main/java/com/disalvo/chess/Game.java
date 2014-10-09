package com.disalvo.chess;

public class Game {

	private final Board board;

	public Game(final Board board) {
		this.board = board;
	}

	public void chooseSquare(final Square square) {
		board.chooseSquare(square);
	}

	public void start() {
		board.prepareToPlay();
	}
}