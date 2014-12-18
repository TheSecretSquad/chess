package com.disalvo.chess;

public interface PieceFactory {

	Piece createPiece(final PieceType pieceType, final Color color);
}