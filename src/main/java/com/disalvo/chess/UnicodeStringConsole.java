package com.disalvo.chess;

import java.util.EnumMap;
import java.util.Map;

public class UnicodeStringConsole implements Console {

	private static final String verticalBar = "\u2502";
	private static final String emptyLightSpace = "\u2504\u2504";
	private static final String emptyDarkSpace = "\u2505\u2505";
	
	private static final Map<ChessPieceType, UnicodeStringPiece> darkStringPieces = new EnumMap<>(ChessPieceType.class);
	static {
		darkStringPieces.put(ChessPieceType.BISHOP, UnicodeStringPiece.DARK_BISHOP);
		darkStringPieces.put(ChessPieceType.KING, UnicodeStringPiece.DARK_KING);
		darkStringPieces.put(ChessPieceType.KNIGHT, UnicodeStringPiece.DARK_KNIGHT);
		darkStringPieces.put(ChessPieceType.PAWN, UnicodeStringPiece.DARK_PAWN);
		darkStringPieces.put(ChessPieceType.QUEEN, UnicodeStringPiece.DARK_QUEEN);
		darkStringPieces.put(ChessPieceType.ROOK, UnicodeStringPiece.DARK_ROOK);
	}
	
	private static final Map<ChessPieceType, UnicodeStringPiece> lightStringPieces = new EnumMap<>(ChessPieceType.class);
	static {
		lightStringPieces.put(ChessPieceType.BISHOP, UnicodeStringPiece.LIGHT_BISHOP);
		lightStringPieces.put(ChessPieceType.KING, UnicodeStringPiece.LIGHT_KING);
		lightStringPieces.put(ChessPieceType.KNIGHT, UnicodeStringPiece.LIGHT_KNIGHT);
		lightStringPieces.put(ChessPieceType.PAWN, UnicodeStringPiece.LIGHT_PAWN);
		lightStringPieces.put(ChessPieceType.QUEEN, UnicodeStringPiece.LIGHT_QUEEN);
		lightStringPieces.put(ChessPieceType.ROOK, UnicodeStringPiece.LIGHT_ROOK);
	}
	
	private static final Map<Color, Map<ChessPieceType, UnicodeStringPiece>> colorSet = new EnumMap<>(Color.class);
	static {
		colorSet.put(Color.DARK, darkStringPieces);
		colorSet.put(Color.LIGHT, lightStringPieces);
	}
	
	private static UnicodeStringPiece getStringPiece(final ChessPieceType pieceType, final Color color) {
		return colorSet.get(color).get(pieceType);
	}
	
	@Override
	public void printPieceTypeOfColor(final ChessPieceType pieceType, final Color color) {
		printSquareWithContent(getStringPiece(pieceType, color).toString());
	}
	
	@Override
	public void printEmptyLightSquare() {
		printSquareWithContent(emptyLightSpace);
	}

	@Override
	public void printEmptyDarkSquare() {
		printSquareWithContent(emptyDarkSpace);
	}

	@Override
	public void startNewRank() {
		System.out.print(verticalBar);
		System.out.println();
	}
	
	private void printSquareWithContent(final String squareContent) {
		System.out.printf("%s%s", verticalBar, squareContent);
	}
}