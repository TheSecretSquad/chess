package com.disalvo.chess;

public interface PieceConsumer {

	void givePiece(final Piece piece);
	
	void noPiece();
}