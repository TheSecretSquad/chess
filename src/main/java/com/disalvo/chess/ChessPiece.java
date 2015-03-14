package com.disalvo.chess;

public abstract class ChessPiece implements Piece {

	private final ChessPieceType chessPieceType;
	private final Color color;
	private final PieceTargetting pieceTargetting;

	public ChessPiece(final ChessPieceType pieceType, final Color color, final PieceTargetting pieceTargetting) {
		this.chessPieceType = pieceType;
		this.color = color;
		this.pieceTargetting = pieceTargetting;
	}

	@Override
	public final void printTo(final Console console) {
		console.printPieceTypeOfColor(chessPieceType, color);
	}

	@Override
	public final void targetFromSquareTo(final Square originSquare, final MovesReceiver movesReceiver) {
		targetFromSquareWithReceiverUsing(originSquare, movesReceiver, pieceTargetting);
	}

	protected abstract void targetFromSquareWithReceiverUsing(
			final Square originSquare, final MovesReceiver movesReceiver, final PieceTargetting pieceTargetting);
}