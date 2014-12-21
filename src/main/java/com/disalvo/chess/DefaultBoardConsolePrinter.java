package com.disalvo.chess;

public class DefaultBoardConsolePrinter implements BoardConsolePrinter {

	private final Console console;
	private final SquareProvider squareProvider;
	private boolean isLightSquare = true;
	
	public DefaultBoardConsolePrinter(final Console console, final SquareProvider squareProvider) {
		this.console = console;
		this.squareProvider = squareProvider;
	}
	
	@Override
	public void printFrom(final PieceProvider pieceProvider) {
		squareProvider.provideRanksInReverseTo(new SquareRankConsumer() {

			@Override
			public void giveSquare(final Square square) {
				printSquareContent(square, pieceProvider);
			}

			@Override
			public void endRank() {
				startNewRank();
			}	
		});
	}
	
	private void printSquareContent(final Square square, final PieceProvider pieceProvider) {
		printPiece(square, pieceProvider);
		trackSquareColor();
	}

	private void printPiece(final Square square, final PieceProvider pieceProvider) {
		pieceProvider.providePieceAtSquareTo(square, new SquarePieceConsumer() {

			@Override
			public void givePiece(final Piece piece) {
				piece.printTo(console);
			}

			@Override
			public void noPiece() {
				printEmptySquare();
			}
		});
	}

	private void printEmptySquare() {
		if(isLightSquare)
			console.printEmptyLightSquare();
		else
			console.printEmptyDarkSquare();
	}
	
	private void trackSquareColor() {
		isLightSquare = isLightSquare ? false : true;
	}

	private void startNewRank() {
		isLightSquare = !isLightSquare;
		console.startNewRank();
	}
}