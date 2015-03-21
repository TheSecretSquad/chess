package com.disalvo.chess;

public abstract class ChessPiece implements Piece {

	private final ChessPieceType chessPieceType;
	private final Color color;
	private final PieceTargetingFactory pieceTargetingFactory;

	public ChessPiece(final ChessPieceType pieceType, final Color color, final PieceTargetingFactory pieceTargetingFactory) {
		this.chessPieceType = pieceType;
		this.color = color;
		this.pieceTargetingFactory = pieceTargetingFactory;
	}

	@Override
	public final void printTo(final Console console) {
		console.printPieceTypeOfColor(chessPieceType, color);
	}

	@Override
	public void choose(final Square square, final MovesReceiver movesReceiver, final PieceAtSquareProvider pieceAtSquareProvider) {
		choose(pieceTargetingFactory.create(square, this, movesReceiver));
		
	}
	
	protected abstract void choose(final ChessPieceTargeting chessPieceTargeting);
}