package com.disalvo.chess;

public interface SquarePieceConsumer {

	void givePiece(final Piece piece);
	
	void noPiece();
}