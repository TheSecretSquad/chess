package com.disalvo.chess;

import java.util.EnumMap;
import java.util.Map;

public class DefaultConsole implements Console {

	private static final String verticalBar = "\u2502";
	private static final String emptyLightSpace = "\u2504\u2504";
	private static final String emptyDarkSpace = "\u2505\u2505";
	
	private static final Map<PieceType, UnicodeStringPiece> darkStringPieces = new EnumMap<>(PieceType.class);
	static {
		darkStringPieces.put(PieceType.BISHOP, UnicodeStringPiece.DARK_BISHOP);
		darkStringPieces.put(PieceType.KING, UnicodeStringPiece.DARK_KING);
		darkStringPieces.put(PieceType.KNIGHT, UnicodeStringPiece.DARK_KNIGHT);
		darkStringPieces.put(PieceType.PAWN, UnicodeStringPiece.DARK_PAWN);
		darkStringPieces.put(PieceType.QUEEN, UnicodeStringPiece.DARK_QUEEN);
		darkStringPieces.put(PieceType.ROOK, UnicodeStringPiece.DARK_ROOK);
	}
	
	private static final Map<PieceType, UnicodeStringPiece> lightStringPieces = new EnumMap<>(PieceType.class);
	static {
		lightStringPieces.put(PieceType.BISHOP, UnicodeStringPiece.LIGHT_BISHOP);
		lightStringPieces.put(PieceType.KING, UnicodeStringPiece.LIGHT_KING);
		lightStringPieces.put(PieceType.KNIGHT, UnicodeStringPiece.LIGHT_KNIGHT);
		lightStringPieces.put(PieceType.PAWN, UnicodeStringPiece.LIGHT_PAWN);
		lightStringPieces.put(PieceType.QUEEN, UnicodeStringPiece.LIGHT_QUEEN);
		lightStringPieces.put(PieceType.ROOK, UnicodeStringPiece.LIGHT_ROOK);
	}
	
	private static final Map<Color, Map<PieceType, UnicodeStringPiece>> colorSet = new EnumMap<>(Color.class);
	static {
		colorSet.put(Color.DARK, darkStringPieces);
		colorSet.put(Color.LIGHT, lightStringPieces);
	}
	
	private static UnicodeStringPiece getStringPiece(final PieceType pieceType, final Color color) {
		return colorSet.get(color).get(pieceType);
	}
	
	@Override
	public void printPieceTypeOfColor(final PieceType pieceType, final Color color) {
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