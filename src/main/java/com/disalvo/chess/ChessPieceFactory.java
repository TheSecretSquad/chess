package com.disalvo.chess;

public class ChessPieceFactory implements PieceFactory {
	
	@Override
	public Piece createPiece(final ChessPieceType pieceType, final Color color) {
		if(pieceType == null) throw new UnknownPieceTypeException();
		
		switch(pieceType) {
			case BISHOP:
				return new Bishop(color);
			case KING:
				return new King(color);
			case KNIGHT:
				return new Knight(color);
			case PAWN:
				return new Pawn(color);
			case QUEEN:
				return new Queen(color);
			case ROOK:
				return new Rook(color);
			default:
				throw new UnknownPieceTypeException();
		}
	}
}
