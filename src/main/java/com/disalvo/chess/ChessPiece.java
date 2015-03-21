package com.disalvo.chess;

public abstract class ChessPiece implements Piece {

	private final ChessPieceType chessPieceType;
	private final Color color;
	private final ChessPieceTargetingFactory chessPieceTargetingFactory;

	public ChessPiece(final ChessPieceType pieceType, final Color color, final ChessPieceTargetingFactory chessPieceTargetingFactory) {
		this.chessPieceType = pieceType;
		this.color = color;
		this.chessPieceTargetingFactory = chessPieceTargetingFactory;
	}

	@Override
	public final void printTo(final Console console) {
		console.printPieceTypeOfColor(chessPieceType, color);
	}

	@Override
	public void choose(final Square square, final MovesReceiver movesReceiver, final PieceAtSquareProvider pieceAtSquareProvider) {
		choose(chessPieceTargetingFactory.create(square, this, pieceAtSquareProvider, movesReceiver));
		
	}
	
	protected abstract void choose(final ChessPieceTargeting chessPieceTargeting);
}