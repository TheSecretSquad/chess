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
	
	public static void main(String[] args) {
		Game game = createDefaultGame();
		game.start();
	}
	
	private static Game createDefaultGame() {
		BoardConsolePrinter boardConsolePrinter = new DefaultBoardConsolePrinter(new DefaultConsole(), new DefaultSquareProvider());
		return new Game(new ChessBoard(boardConsolePrinter), new StandardChessConfiguration(configurePieceSet()), null);
	}

	private static PieceSet configurePieceSet() {
		DefaultPieceSet defaultPieceSet = new DefaultPieceSet();
		defaultPieceSet.registerPieceTypeOfColorWith(PieceType.BISHOP, Color.LIGHT, new Bishop(Color.LIGHT));
		defaultPieceSet.registerPieceTypeOfColorWith(PieceType.BISHOP, Color.DARK, new Bishop(Color.DARK));
		defaultPieceSet.registerPieceTypeOfColorWith(PieceType.KING, Color.LIGHT, new King(Color.LIGHT));
		defaultPieceSet.registerPieceTypeOfColorWith(PieceType.KING, Color.DARK, new King(Color.DARK));
		defaultPieceSet.registerPieceTypeOfColorWith(PieceType.KNIGHT, Color.LIGHT, new Knight(Color.LIGHT));
		defaultPieceSet.registerPieceTypeOfColorWith(PieceType.KNIGHT, Color.DARK, new Knight(Color.DARK));
		defaultPieceSet.registerPieceTypeOfColorWith(PieceType.PAWN, Color.LIGHT, new Pawn(Color.LIGHT));
		defaultPieceSet.registerPieceTypeOfColorWith(PieceType.PAWN, Color.DARK, new Pawn(Color.DARK));
		defaultPieceSet.registerPieceTypeOfColorWith(PieceType.QUEEN, Color.LIGHT, new Queen(Color.LIGHT));
		defaultPieceSet.registerPieceTypeOfColorWith(PieceType.QUEEN, Color.DARK, new Queen(Color.DARK));
		defaultPieceSet.registerPieceTypeOfColorWith(PieceType.ROOK, Color.LIGHT, new Rook(Color.LIGHT));
		defaultPieceSet.registerPieceTypeOfColorWith(PieceType.ROOK, Color.DARK, new Rook(Color.DARK));
		return defaultPieceSet;
	}
}