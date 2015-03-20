package com.disalvo.chess;

import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
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
	@Mock
	private PieceTargetingFactory pieceTargetingFactory;

	@Before
	public void setUp() throws Exception {
		pawn = new Pawn(Color.LIGHT, pieceTargetingFactory);
	}

	@Test
	public void shouldTargetTwoForwardIfNeverMovedWhenChosen() {
		TargetingCount neverMovedCount = new TargetingCount(2);
		pawn.choose(pieceTargeting);
		verify(pieceTargeting).path(eq(RankDirection.FORWARD), eq(neverMovedCount), isA(TargetingCount.class));
	}

	@Test
	public void shouldTargetOneForwardIfHasMovedWhenChosen() {
		TargetingCount hasMovedCount = new TargetingCount(1);
		pawn.choose(pieceTargeting);
		verify(pieceTargeting).path(eq(RankDirection.FORWARD), isA(TargetingCount.class), eq(hasMovedCount));
	}
	
	@Test
	public void shouldAttackOneForwardLeftWhenChosen() {
		TargetingCount hasMovedCount = new TargetingCount(1);
		pawn.choose(pieceTargeting);
		verify(pieceTargeting).attack(eq(RankDirection.FORWARD), eq(FileDirection.LEFT));
	}
}