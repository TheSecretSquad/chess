package com.disalvo.chess;

public class ChessPieceFactory implements PieceFactory {

	private final PieceTargetingFactory pieceTargetingFactory;
	
	public ChessPieceFactory(final PieceTargetingFactory pieceTargetingFactory) {
		this.pieceTargetingFactory = pieceTargetingFactory;
	}
	
	@Override
	public Piece createPiece(final ChessPieceType pieceType, final Color color) {
		if(pieceType == null) throw new UnknownPieceTypeException();
		
		switch(pieceType) {
			case BISHOP:
				return new Bishop(color, pieceTargetingFactory);
			case KING:
				return new King(color, pieceTargetingFactory);
			case KNIGHT:
				return new Knight(color, pieceTargetingFactory);
			case PAWN:
				return new Pawn(color, pieceTargetingFactory);
			case QUEEN:
				return new Queen(color, pieceTargetingFactory);
			case ROOK:
				return new Rook(color, pieceTargetingFactory);
			default:
				throw new UnknownPieceTypeException();
		}
	}
}
