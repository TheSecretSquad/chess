package com.disalvo.chess;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.AdditionalMatchers.not;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StandardChessConfigurationTest {

	private StandardChessConfiguration standardChessConfiguration;
	@Mock
	private Board board;
	@Mock
	private PieceFactory pieceFactory;
	@Mock
	private Piece expectedPiece;
	@Mock
	private Piece notExpectedPiece;

	
	@Before
	public void setUp() throws Exception {
		standardChessConfiguration = new StandardChessConfiguration(pieceFactory);
	}

	private void setupMockFactoryToExpect(final PieceType pieceType, final Color color) {
		when(pieceFactory.createPiece(eq(pieceType), eq(color))).thenReturn(expectedPiece);
		when(pieceFactory.createPiece(not(eq(pieceType)), not(eq(color)))).thenReturn(notExpectedPiece);
	}
	
	private void verifyExpectedPiecePlacedAt(final Square ... squares) {
		verifyPiecePlacedAt(expectedPiece, squares);
	}
	
	private void verifyPiecePlacedAt(final Piece piece, final Square ... squares) {
		standardChessConfiguration.setup(board);
		for(Square s : squares) {
			verify(board).placePieceAt(piece, s);
		}
	}
	
	@Test
	public void shouldFillRank2WithLightPawnsWhenSettingUp() {
		setupMockFactoryToExpect(PieceType.PAWN, Color.LIGHT);
		verifyExpectedPiecePlacedAt(Square.A2, Square.B2, Square.C2, Square.D2,
				Square.E2, Square.F2, Square.G2, Square.H2);
	}
	
	@Test
	public void shouldPlaceLightRookAtA1AndH1WhenSettingUp() {
		setupMockFactoryToExpect(PieceType.ROOK, Color.LIGHT);
		verifyExpectedPiecePlacedAt(Square.A1, Square.H1);
	}
	
	@Test
	public void shouldPlaceLightKnightAtB1AndG1WhenSettingUp() {
		setupMockFactoryToExpect(PieceType.KNIGHT, Color.LIGHT);
		verifyExpectedPiecePlacedAt(Square.B1, Square.G1);
	}
	
	@Test
	public void shouldPlaceLightBishopAtC1AndF1WhenSettingUp() {
		setupMockFactoryToExpect(PieceType.BISHOP, Color.LIGHT);
		verifyExpectedPiecePlacedAt(Square.C1, Square.F1);
	}
	
	@Test
	public void shouldPlaceLightKingAtD1WhenSettingUp() {
		setupMockFactoryToExpect(PieceType.KING, Color.LIGHT);
		verifyExpectedPiecePlacedAt(Square.D1);
	}
	
	@Test
	public void shouldPlaceLightQueenAtE1WhenSettingUp() {
		setupMockFactoryToExpect(PieceType.QUEEN, Color.LIGHT);
		verifyExpectedPiecePlacedAt(Square.E1);
	}
	
	@Test
	public void shouldFillRank7WithDarkPawnsWhenSettingUp() {
		setupMockFactoryToExpect(PieceType.PAWN, Color.DARK);
		verifyExpectedPiecePlacedAt(Square.A7, Square.B7, Square.C7,
				Square.D7, Square.E7, Square.F7, Square.G7, Square.H7);
	}
	
	@Test
	public void shouldPlaceDarkRookAtA8AndH8WhenSettingUp() {
		setupMockFactoryToExpect(PieceType.ROOK, Color.DARK);
		verifyExpectedPiecePlacedAt(Square.A8, Square.H8);
	}
	
	@Test
	public void shouldPlaceDarkKnightAtB8AndG8WhenSettingUp() {
		setupMockFactoryToExpect(PieceType.KNIGHT, Color.DARK);
		verifyExpectedPiecePlacedAt(Square.B8, Square.G8);
	}
	
	@Test
	public void shouldPlaceDarkBishopAtC8AndF8WhenSettingUp() {
		setupMockFactoryToExpect(PieceType.BISHOP, Color.DARK);
		verifyExpectedPiecePlacedAt(Square.C8, Square.F8);
	}
	
	@Test
	public void shouldPlaceDarkKingAtD8WhenSettingUp() {
		setupMockFactoryToExpect(PieceType.KING, Color.DARK);
		verifyExpectedPiecePlacedAt(Square.D8);
	}
	
	@Test
	public void shouldPlaceDarkQueenAtE8WhenSettingUp() {
		setupMockFactoryToExpect(PieceType.QUEEN, Color.DARK);
		verifyExpectedPiecePlacedAt(Square.E8);
	}
}