package com.disalvo.chess;

public abstract class ChessPiece implements Piece {

	private final PieceType pieceType;
	private final Color color;

	public ChessPiece(final PieceType pieceType, final Color color) {
		this.pieceType = pieceType;
		this.color = color;
	}

	@Override
	public final void printTo(final Console console) {
		console.printPieceTypeOfColor(pieceType, color);
	}
}