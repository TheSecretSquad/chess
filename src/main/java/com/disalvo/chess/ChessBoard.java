package com.disalvo.chess;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ChessBoard implements Board, PieceAtSquareProvider {

	private final BoardConsolePrinter boardConsolePrinter;
	private final MovesReceiver movesReceiver;
	private final Map<Square, Piece> pieces;
	
	public ChessBoard(final BoardConsolePrinter boardConsolePrinter, final MovesReceiver movesReceiver) {
		this.boardConsolePrinter = boardConsolePrinter;
		this.movesReceiver = movesReceiver;
		this.pieces = new HashMap<>();
	}
	
	@Override
	public void chooseSquare(final Square square) {
		targetFromSquareWith(square, pieces.get(square));
	}

	private void targetFromSquareWith(final Square square, final Piece piece) {
		if(piece == null)
			return;
		
		piece.targetFromSquareTo(square, movesReceiver);
	}

	@Override
	public void printToConsole() {
		boardConsolePrinter.printFrom(this);
	}

	@Override
	public void configureAs(final ChessConfiguration chessConfiguration) {	
		chessConfiguration.setup(this);
	}

	@Override
	public void submitMove(final Square fromSquare, final Square toSquare) {		
	}

	@Override
	public void placePieceAt(final Piece piece, final Square square) {
		pieces.put(square, piece);
	}

	@Override
	public void providePieceAtSquareTo(Square square, PieceAtSquareConsumer pieceConsumer) {
		Piece piece = pieces.get(square);
		if(Objects.isNull(piece))
			pieceConsumer.noPiece();
		else {
			pieceConsumer.givePiece(piece);
		}
	}
}