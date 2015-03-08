package com.disalvo.chess;

public abstract class PieceFactory {

	private PieceTargetting pieceTargetting;
	
	public PieceFactory(final PieceTargetting pieceTargetting) {
		this.pieceTargetting = pieceTargetting;
	}
	
	public final Piece createPiece(final ChessPieceType pieceType, final Color color) {
		return createPiece(pieceType, color, pieceTargetting);
	}
	
	protected abstract Piece createPiece(final ChessPieceType pieceType, final Color color, final PieceTargetting pieceTargetting);
}