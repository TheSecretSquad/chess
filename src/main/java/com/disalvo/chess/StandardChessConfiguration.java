package com.disalvo.chess;

public class StandardChessConfiguration implements ChessConfiguration{

	private final PieceFactory pieceFactory;

	public StandardChessConfiguration(final PieceFactory pieceFactory) {
		this.pieceFactory = pieceFactory;
	}
	
	@Override
	public void setup(final Board board) {
		setupLightPieces(board);
		setupDarkPieces(board);
	}
	
	private void setupLightPieces(final Board board) {
		setupLightPawns(board);
		setupLightRooks(board);
		setupLightKnights(board);
		setupLightBishops(board);
		setupLightKingAndQueen(board);
	}

	private void setupLightPawns(final Board board) {
		placePieceTypeOfColorOnBoardAt(PieceType.PAWN, Color.LIGHT, board,
				Square.A2, Square.B2, Square.C2, Square.D2,
				Square.E2, Square.F2, Square.G2, Square.H2);
	}

	private void setupLightRooks(final Board board) {
		placePieceTypeOfColorOnBoardAt(PieceType.ROOK, Color.LIGHT, board, Square.A1, Square.H1);	
	}

	private void setupLightKnights(final Board board) {
		placePieceTypeOfColorOnBoardAt(PieceType.KNIGHT, Color.LIGHT, board, Square.B1, Square.G1);
	}
	
	private void setupLightBishops(final Board board) {
		placePieceTypeOfColorOnBoardAt(PieceType.BISHOP, Color.LIGHT, board, Square.C1, Square.F1);
	}
	
	private void setupLightKingAndQueen(final Board board) {
		placePieceTypeOfColorOnBoardAt(PieceType.KING, Color.LIGHT, board, Square.D1);
		placePieceTypeOfColorOnBoardAt(PieceType.QUEEN, Color.LIGHT, board, Square.E1);
	}
	
	private void setupDarkPieces(final Board board) {
		setupDarkPawns(board);
		setupDarkRooks(board);
		setupDarkKnights(board);
		setupDarkBishops(board);
		setupDarkKingAndQueen(board);
	}

	private void setupDarkPawns(final Board board) {
		placePieceTypeOfColorOnBoardAt(PieceType.PAWN, Color.DARK, board,
				Square.A7, Square.B7, Square.C7, Square.D7,
				Square.E7, Square.F7, Square.G7, Square.H7);
	}

	private void setupDarkRooks(final Board board) {
		placePieceTypeOfColorOnBoardAt(PieceType.ROOK, Color.DARK, board, Square.A8, Square.H8);
	}

	private void setupDarkKnights(final Board board) {
		placePieceTypeOfColorOnBoardAt(PieceType.KNIGHT, Color.DARK, board, Square.B8, Square.G8);
	}

	private void setupDarkBishops(final Board board) {
		placePieceTypeOfColorOnBoardAt(PieceType.BISHOP, Color.DARK, board, Square.C8, Square.F8);
	}

	private void setupDarkKingAndQueen(final Board board) {
		placePieceTypeOfColorOnBoardAt(PieceType.KING, Color.DARK, board, Square.D8);
		placePieceTypeOfColorOnBoardAt(PieceType.QUEEN, Color.DARK, board, Square.E8);
	}
	
	private void placePieceTypeOfColorOnBoardAt(final PieceType pieceType, final Color color, final Board board, final Square ... squares) {
		for(Square s : squares) {
			board.placePieceAt(pieceFactory.createPiece(pieceType, color), s);
		}
	}
}