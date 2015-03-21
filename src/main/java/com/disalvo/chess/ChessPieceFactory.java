package com.disalvo.chess;

public class ChessPieceFactory implements PieceFactory {

	private final ChessPieceTargetingFactory chessPieceTargetingFactory;
	
	public ChessPieceFactory(final ChessPieceTargetingFactory chessPieceTargetingFactory) {
		this.chessPieceTargetingFactory = chessPieceTargetingFactory;
	}
	
	@Override
	public Piece createPiece(final ChessPieceType pieceType, final Color color) {
		if(pieceType == null) throw new UnknownPieceTypeException();
		
		switch(pieceType) {
			case BISHOP:
				return new Bishop(color, chessPieceTargetingFactory);
			case KING:
				return new King(color, chessPieceTargetingFactory);
			case KNIGHT:
				return new Knight(color, chessPieceTargetingFactory);
			case PAWN:
				return new Pawn(color, chessPieceTargetingFactory);
			case QUEEN:
				return new Queen(color, chessPieceTargetingFactory);
			case ROOK:
				return new Rook(color, chessPieceTargetingFactory);
			default:
				throw new UnknownPieceTypeException();
		}
	}
}
