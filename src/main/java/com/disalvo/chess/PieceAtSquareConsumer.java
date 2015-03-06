package com.disalvo.chess;

public interface PieceAtSquareConsumer {

	void givePiece(final Piece piece);
	
	void noPiece();
}