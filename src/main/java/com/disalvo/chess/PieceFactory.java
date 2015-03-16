package com.disalvo.chess;

public interface PieceFactory {
	
	Piece createPiece(final ChessPieceType pieceType, final Color color);
}