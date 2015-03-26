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
public class DefaultReverseRankSquareProviderTest {

	private DefaultReverseRankSquareProvider squareProvider;
	@Mock
	private ByRankSquareConsumer squareRankConsumer;
	private ReverseByRankSquareVerifier orderedResultsSquareRankConsumer = new ReverseByRankSquareVerifier();
	
	private static class ReverseByRankSquareVerifier implements ByRankSquareConsumer {
		private final List<Square> resultList = new ArrayList<>();

		@Override
		public void giveSquare(final Square square) {
			resultList.add(square);
		}

		@Override
		public void endRank() { /* Unused in test */}
		
		public void verifyInOrder() {
			assertEquals(resultList.get(0), Square.A8);
			assertEquals(resultList.get(1), Square.B8);
			assertEquals(resultList.get(7), Square.H8);
			assertEquals(resultList.get(63), Square.H1);
		}
	};
	
	private void verifySquaresConsumedInOrder() {
		orderedResultsSquareRankConsumer.verifyInOrder();
	}
	
	@Before
	public void setUp() throws Exception {
		squareProvider = new DefaultReverseRankSquareProvider();
	}

	@Test
	public void shouldConsumeSquaresInFileOrderWhenProvidingSquares() {
		squareProvider.provideSquaresTo(orderedResultsSquareRankConsumer);
		verifySquaresConsumedInOrder();
	}
	
	@Test
	public void shouldConsume64SquaresWhenProvidingRanks() {
		squareProvider.provideSquaresTo(squareRankConsumer);
		verify(squareRankConsumer, times(64)).giveSquare(any(Square.class));
	}
	
	@Test
	public void shouldReport8EndRanksWhenProvidingRanks() {
		squareProvider.provideSquaresTo(squareRankConsumer);
		verify(squareRankConsumer, times(8)).endRank();
	}
}