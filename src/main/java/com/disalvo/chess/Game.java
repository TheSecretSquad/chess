package com.disalvo.chess;

public class Game {

	private final Board board;
	private final MovesReceiver movesReceiver;
	private final ChessConfiguration chessConfiguration;

	public Game(final Board board, final ChessConfiguration chessConfiguration, final MovesReceiver movesReceiver) {
		this.board = board;
		this.movesReceiver = movesReceiver;
		this.chessConfiguration = chessConfiguration;
	}

	public void chooseSquare(final Square square) {
		board.sendMovesForTo(square, movesReceiver);
	}

	public void start() {
		setupBoard();
		printBoard();
	}
	
	private void setupBoard() {
		board.setupAs(chessConfiguration);
	}
	
	private void printBoard() {
		board.printToConsole();
	}
	
	public void submitMove(final Square fromSquare, final Square toSquare) {
		board.move(fromSquare, toSquare);
	}
}