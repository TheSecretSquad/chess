package com.disalvo.chess;

public class Game {

	private final Board board;
	private final MovesReceiver movesReceiver;
	private StartingPieceConfiguration startingPieceConfiguration;

	public Game(final Board board, final StartingPieceConfiguration startingPieceConfiguration, MovesReceiver movesReceiver) {
		this.board = board;
		this.movesReceiver = movesReceiver;
		this.startingPieceConfiguration = startingPieceConfiguration;
	}

	public void chooseSquare(final Square square) {
		board.sendMovesForTo(square, movesReceiver);
	}

	public void start() {
		startingPieceConfiguration.setup(board);
		board.printToConsole();
	}
}