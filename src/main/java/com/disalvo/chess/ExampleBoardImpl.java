package com.disalvo.chess;

public class ExampleBoardImpl implements Board {

	private StartingPieceConfiguration startingPieceConfiguration;
	private MovesReceiver movesReceiver;
	
	public ExampleBoardImpl(StartingPieceConfiguration startingPieceConfiguration, MovesReceiver movesReceiver) {
		this.movesReceiver = movesReceiver;
	}
	
	@Override
	public void chooseSquare(Square square) {
		// Send moves to the movesReceiver
	}

	@Override
	public void prepareToPlay() {
		// Setup pieces with starting configuration
		// Print (display) the board
	}
}