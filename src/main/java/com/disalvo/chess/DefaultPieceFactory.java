package com.disalvo.chess;

public class DefaultPieceFactory extends PieceFactory {

	public DefaultPieceFactory(PieceTargetting pieceTargetting) {
		super(pieceTargetting);
	}

	// TODO: Remove PieceTargetting parameter 
	@Override
	public Piece createPiece(final ChessPieceType pieceType, final Color color, final PieceTargetting pieceTargetting) {
		if(pieceType == null) throw new UnknownPieceTypeException();
		
		switch(pieceType) {
			case BISHOP:
				return new Bishop(color, pieceTargetting);
			case KING:
				return new King(color, pieceTargetting);
			case KNIGHT:
				return new Knight(color, pieceTargetting);
			case PAWN:
				return new Pawn(color, pieceTargetting);
			case QUEEN:
				return new Queen(color, pieceTargetting);
			case ROOK:
				return new Rook(color, pieceTargetting);
			default:
				throw new UnknownPieceTypeException();
		}
	}
}
