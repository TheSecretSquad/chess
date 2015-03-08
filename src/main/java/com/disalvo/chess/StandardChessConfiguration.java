package com.disalvo.chess;

public class StandardChessConfiguration implements ChessConfiguration{

	private final PieceFactory pieceFactory;

	public StandardChessConfiguration(final PieceFactory pieceFactory) {
		this.pieceFactory = pieceFactory;
	}
	
	@Override
	public void setup(final BoardSetup boardSetup) {
		setupLightPieces(boardSetup);
		setupDarkPieces(boardSetup);
	}
	
	private void setupLightPieces(final BoardSetup boardsetup) {
		setupLightPawns(boardsetup);
		setupLightRooks(boardsetup);
		setupLightKnights(boardsetup);
		setupLightBishops(boardsetup);
		setupLightKingAndQueen(boardsetup);
	}

	private void setupLightPawns(final BoardSetup boardsetup) {
		placePieceTypeOfColorOnBoardAt(ChessPieceType.PAWN, Color.LIGHT, boardsetup,
				Square.A2, Square.B2, Square.C2, Square.D2,
				Square.E2, Square.F2, Square.G2, Square.H2);
	}

	private void setupLightRooks(final BoardSetup boardsetup) {
		placePieceTypeOfColorOnBoardAt(ChessPieceType.ROOK, Color.LIGHT, boardsetup, Square.A1, Square.H1);	
	}

	private void setupLightKnights(final BoardSetup boardsetup) {
		placePieceTypeOfColorOnBoardAt(ChessPieceType.KNIGHT, Color.LIGHT, boardsetup, Square.B1, Square.G1);
	}
	
	private void setupLightBishops(final BoardSetup boardsetup) {
		placePieceTypeOfColorOnBoardAt(ChessPieceType.BISHOP, Color.LIGHT, boardsetup, Square.C1, Square.F1);
	}
	
	private void setupLightKingAndQueen(final BoardSetup boardsetup) {
		placePieceTypeOfColorOnBoardAt(ChessPieceType.KING, Color.LIGHT, boardsetup, Square.D1);
		placePieceTypeOfColorOnBoardAt(ChessPieceType.QUEEN, Color.LIGHT, boardsetup, Square.E1);
	}
	
	private void setupDarkPieces(final BoardSetup boardsetup) {
		setupDarkPawns(boardsetup);
		setupDarkRooks(boardsetup);
		setupDarkKnights(boardsetup);
		setupDarkBishops(boardsetup);
		setupDarkKingAndQueen(boardsetup);
	}

	private void setupDarkPawns(final BoardSetup boardsetup) {
		placePieceTypeOfColorOnBoardAt(ChessPieceType.PAWN, Color.DARK, boardsetup,
				Square.A7, Square.B7, Square.C7, Square.D7,
				Square.E7, Square.F7, Square.G7, Square.H7);
	}

	private void setupDarkRooks(final BoardSetup boardsetup) {
		placePieceTypeOfColorOnBoardAt(ChessPieceType.ROOK, Color.DARK, boardsetup, Square.A8, Square.H8);
	}

	private void setupDarkKnights(final BoardSetup boardsetup) {
		placePieceTypeOfColorOnBoardAt(ChessPieceType.KNIGHT, Color.DARK, boardsetup, Square.B8, Square.G8);
	}

	private void setupDarkBishops(final BoardSetup boardsetup) {
		placePieceTypeOfColorOnBoardAt(ChessPieceType.BISHOP, Color.DARK, boardsetup, Square.C8, Square.F8);
	}

	private void setupDarkKingAndQueen(final BoardSetup boardsetup) {
		placePieceTypeOfColorOnBoardAt(ChessPieceType.KING, Color.DARK, boardsetup, Square.D8);
		placePieceTypeOfColorOnBoardAt(ChessPieceType.QUEEN, Color.DARK, boardsetup, Square.E8);
	}
	
	private void placePieceTypeOfColorOnBoardAt(final ChessPieceType pieceType, final Color color, final BoardSetup boardsetup, final Square ... squares) {
		for(Square s : squares) {
			boardsetup.placePieceAt(pieceFactory.createPiece(pieceType, color), s);
		}
	}
}