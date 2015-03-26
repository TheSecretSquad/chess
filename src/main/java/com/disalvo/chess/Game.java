package com.disalvo.chess;

public class Game {

	private final Board board;
	private final MovesReceiver movesReceiver;
	private final ChessConfiguration chessConfiguration;

	public Game(final Board board, final MovesReceiver movesReceiver, final ChessConfiguration chessConfiguration) {
		this.board = board;
		this.movesReceiver = movesReceiver;
		this.chessConfiguration = chessConfiguration;
	}

	public void chooseSquare(final Square square) {
		board.sendMovesForSquareTo(square, movesReceiver);
	}

	public void start() {
		setupBoard();
		printBoard();
	}
	
	private void setupBoard() {
		board.configureAs(chessConfiguration);
	}
	
	private void printBoard() {
		board.printToConsole();
	}
	
	public static void main(String[] args) {
		Game game = createDefaultGame();
		game.start();
	}
	
	private static Game createDefaultGame() {
		BoardConsolePrinter boardConsolePrinter = new DefaultBoardConsolePrinter(new UnicodeStringConsole(), new DefaultReverseRankSquareProvider());
		return new Game(new ChessBoard(boardConsolePrinter), movesReceiver(), new StandardChessConfiguration(new ChessPieceFactory()));
	}
		
	private static MovesReceiver movesReceiver() {
		return null;
	}
}