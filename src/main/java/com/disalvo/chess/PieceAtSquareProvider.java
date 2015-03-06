package com.disalvo.chess;

public interface PieceAtSquareProvider {

	void providePieceAtSquareTo(final Square square, final PieceAtSquareConsumer pieceConsumer);
}