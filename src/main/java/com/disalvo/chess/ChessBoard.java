package com.disalvo.chess;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ChessBoard implements Board, PieceAtSquareProvider {

	private final BoardConsolePrinter boardConsolePrinter;
	private final Map<Square, Piece> pieces;
	
	public ChessBoard(final BoardConsolePrinter boardConsolePrinter) {
		this.boardConsolePrinter = boardConsolePrinter;
		this.pieces = new HashMap<>();
	}
	
	@Override
	public void sendMovesForSquareTo(final Square square, final MovesReceiver movesReceiver) {
		describePieceMovesTo(pieces.get(square), movesReceiver);
	}
	
	private void describePieceMovesTo(final Piece piece, final MovesReceiver movesReceiver) {
		if(piece != null)
			piece.describeMovesTo(movesReceiver);
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