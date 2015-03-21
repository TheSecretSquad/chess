package com.disalvo.chess;

public class Game {

	private final Board board;
	private final ChessConfiguration chessConfiguration;

	public Game(final Board board, final ChessConfiguration chessConfiguration) {
		this.board = board;
		this.chessConfiguration = chessConfiguration;
	}

	public void chooseSquare(final Square square) {
		board.chooseSquare(square);
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
	
	public void submitMove(final Square fromSquare, final Square toSquare) {
		board.submitMove(fromSquare, toSquare);
	}
	
	public static void main(String[] args) {
		Game game = createDefaultGame();
		game.start();
	}
	
	private static Game createDefaultGame() {
		BoardConsolePrinter boardConsolePrinter = new DefaultBoardConsolePrinter(new UnicodeStringConsole(), new DefaultReverseRankSquareProvider());
		return new Game(new ChessBoard(boardConsolePrinter, movesReceiver()), new StandardChessConfiguration(new ChessPieceFactory(chessPieceTargetingFactory())));
	}
		
	private static MovesReceiver movesReceiver() {
		return null;
	}
	
	private static ChessPieceTargetingFactory chessPieceTargetingFactory() {
		return null;
	}
}