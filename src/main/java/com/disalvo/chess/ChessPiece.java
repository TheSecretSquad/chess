package com.disalvo.chess;

public abstract class ChessPiece implements Piece {

	private final ChessPieceType chessPieceType;
	private final Color color;

	public ChessPiece(final ChessPieceType pieceType, final Color color) {
		this.chessPieceType = pieceType;
		this.color = color;
	}

	@Override
	public final void printTo(final Console console) {
		console.printPieceTypeOfColor(chessPieceType, color);
	}
}