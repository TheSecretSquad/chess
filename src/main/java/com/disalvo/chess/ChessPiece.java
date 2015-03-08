package com.disalvo.chess;

public abstract class ChessPiece implements Piece {

	private final ChessPieceType chessPieceType;
	private final Color color;
	private final PieceTargetting pieceTargetting;

	public ChessPiece(final ChessPieceType pieceType, final Color color, final PieceTargetting pieceTargetting) {
		this.chessPieceType = pieceType;
		this.color = color;
		this.pieceTargetting = pieceTargetting;
	}

	@Override
	public final void printTo(final Console console) {
		console.printPieceTypeOfColor(chessPieceType, color);
	}

	@Override
	public final void targetFromSquareWith(final Square originSquare, final MovesReceiver movesReceiver) {
		targetSteps(new StepSelector() {

			@Override
			public void forward() {
				pieceTargetting.targetForwardFromSquareAsColorWith(originSquare, color, movesReceiver);
			}
		});
	}
	
	protected abstract void targetSteps(final StepSelector stepSelector);
}