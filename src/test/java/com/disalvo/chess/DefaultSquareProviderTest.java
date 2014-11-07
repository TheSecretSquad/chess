package com.disalvo.chess;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultSquareProviderTest {

	private DefaultSquareProvider squareProvider;
	@Mock
	private SquareRankConsumer squareRankConsumer;
	private OrderedResultsSquareRankConsumer orderedResultsSquareRankConsumer = new OrderedResultsSquareRankConsumer();
	
	private static class OrderedResultsSquareRankConsumer implements SquareRankConsumer {
		private final List<Square> resultList = new ArrayList<>();

		@Override
		public void giveSquare(Square square) {
			resultList.add(square);
		}

		@Override
		public void endRank() { /* Unused in test */}
		
		public void verifySquaresInOrder() {
			assertEquals(resultList.get(0), Square.A8);
			assertEquals(resultList.get(1), Square.B8);
			assertEquals(resultList.get(7), Square.H8);
			assertEquals(resultList.get(63), Square.H1);
		}
	};
	
	private void verifySquaresConsumedInOrder() {
		orderedResultsSquareRankConsumer.verifySquaresInOrder();
	}
	
	@Before
	public void setUp() throws Exception {
		squareProvider = new DefaultSquareProvider();
	}

	@Test
	public void shouldConsumeSquaresInFileOrderWhenProvidingSquares() {
		squareProvider.provideRanksInReverseTo(orderedResultsSquareRankConsumer);
		verifySquaresConsumedInOrder();
	}
	
	@Test
	public void shouldConsume64SquaresWhenProvidingRanks() {
		squareProvider.provideRanksInReverseTo(squareRankConsumer);
		verify(squareRankConsumer, times(64)).giveSquare(any(Square.class));
	}
	
	@Test
	public void shouldReport8EndRanksWhenProvidingRanks() {
		squareProvider.provideRanksInReverseTo(squareRankConsumer);
		verify(squareRankConsumer, times(8)).endRank();
	}
}