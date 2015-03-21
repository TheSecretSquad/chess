package com.disalvo.chess;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PawnTest {

	private Pawn pawn;
	private final TargetingCount neverMovedCount = new TargetingCount(2);
	private final TargetingCount hasMovedCount = new TargetingCount(1);
	@Mock
	private MovesReceiver movesReceiver;
	@Mock
	private ChessPieceTargeting chessPieceTargeting;
	@Mock
	private PieceTargetingFactory pieceTargetingFactory;

	@Before
	public void setUp() throws Exception {
		pawn = new Pawn(Color.LIGHT, pieceTargetingFactory);
	}

	@Test
	public void shouldTargetTwoForwardIfNeverMovedWhenChosen() {
		pawn.choose(chessPieceTargeting);
		verify(chessPieceTargeting).pathForward(neverMovedCount);
		verify(chessPieceTargeting, never()).pathForward(hasMovedCount);
	}

	@Test
	public void shouldTargetOneForwardIfHasMovedWhenChosen() {
		TargetingCount hasMovedCount = new TargetingCount(1);
		pawn.move();
		pawn.choose(chessPieceTargeting);
		verify(chessPieceTargeting).pathForward(hasMovedCount);
		verify(chessPieceTargeting, never()).pathForward(neverMovedCount);
	}
	
	@Test
	public void shouldTargetAttackOneForwardRightWhenChosen() {
		pawn.choose(chessPieceTargeting);
		verify(chessPieceTargeting).attackForwardRight();
	}
	
	@Test
	public void shouldTargetAttackOneForwardLeftWhenChosen() {
		pawn.choose(chessPieceTargeting);
		verify(chessPieceTargeting).attackForwardLeft();
	}
}