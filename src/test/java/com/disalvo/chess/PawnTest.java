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
	private PieceTargeting pieceTargeting;
	
	@Before
	public void setUp() throws Exception {
		pawn = new Pawn(Color.LIGHT);
	}
	
	@Test
	public void shouldTargetTwoForwardIfNeverMovedOrOneForwardIfHasMovedWhenChosen() {
		TargetingCount neverMovedCount = new TargetingCount(2);
		TargetingCount hasMovedCount = new TargetingCount(1);
		pawn.choose(pieceTargeting);
		verify(pieceTargeting).pathForward(neverMovedCount, hasMovedCount);
	}
}