package com.disalvo.chess;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PawnTest {

	private Pawn pawn;
	@Mock
	private MovesReceiver movesReceiver;
	@Mock
	private PieceTargetting pieceTargetting;
	
	@Before
	public void setUp() throws Exception {
		pawn = new Pawn(Color.LIGHT, pieceTargetting);
	}

	@Test
	public void targetsEmptySpaceForwardWhenTargetingFromSquare() {
		pawn.targetFromSquareWith(Square.D2, movesReceiver);
		verify(pieceTargetting).targetForwardFromSquareAsColorWith(Square.D2, Color.LIGHT, movesReceiver);
	}
}