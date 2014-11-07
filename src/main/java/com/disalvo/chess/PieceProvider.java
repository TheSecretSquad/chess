package com.disalvo.chess;

public interface PieceProvider {

	void providePieceAtSquareTo(final Square square, final PieceConsumer pieceConsumer);
}