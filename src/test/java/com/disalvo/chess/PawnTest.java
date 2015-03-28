package com.disalvo.chess;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PawnTest {

	private Pawn pawn;

	@Before
	public void setUp() throws Exception {
		pawn = new Pawn(Color.LIGHT);
	}
	
	@Test
	public void shouldTargetTwoSquaresForwardIfHasNotMovedWhenSendingMoves() {

	}
}