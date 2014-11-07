package com.disalvo.chess;

import static org.mockito.Mockito.verify;

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
	private PieceSet pieceSet;
	
	@Before
	public void setUp() throws Exception {
		standardChessConfiguration = new StandardChessConfiguration(pieceSet);
	}

	private void verifyPiecePlacedUsingPieceSetAt(final PieceType pieceType, final Color color, final Square...squares) {
		standardChessConfiguration.setup(board);
		verify(pieceSet).setupPieceTypeOfColorOnBoardAt(pieceType, color, board, squares);
	}
	
	private void verifyLightPiecePlacedAt(final PieceType pieceType, final Square...squares) {
		verifyPiecePlacedUsingPieceSetAt(pieceType, Color.LIGHT, squares);
	}
	
	private void verifyDarkPiecePlacedAt(final PieceType pieceType, final Square...squares) {
		verifyPiecePlacedUsingPieceSetAt(pieceType, Color.DARK, squares);
	}
	
	@Test
	public void shouldFillRank2WithLightPawnsWhenSettingUp() {
		verifyLightPiecePlacedAt(PieceType.PAWN, Square.A2, Square.B2, Square.C2, Square.D2,
				Square.E2, Square.F2, Square.G2, Square.H2);
	}
	
	@Test
	public void shouldPlaceLightRookAtA1AndH1WhenSettingUp() {
		verifyLightPiecePlacedAt(PieceType.ROOK, Square.A1, Square.H1);
	}
	
	@Test
	public void shouldPlaceLightKnightAtB1AndG1WhenSettingUp() {
		verifyLightPiecePlacedAt(PieceType.KNIGHT, Square.B1, Square.G1);
	}
	
	@Test
	public void shouldPlaceLightBishopAtC1AndF1WhenSettingUp() {
		verifyLightPiecePlacedAt(PieceType.BISHOP, Square.C1, Square.F1);
	}
	
	@Test
	public void shouldPlaceLightKingAtD1WhenSettingUp() {
		verifyLightPiecePlacedAt(PieceType.KING, Square.D1);
	}
	
	@Test
	public void shouldPlaceLightQueenAtE1WhenSettingUp() {
		verifyLightPiecePlacedAt(PieceType.QUEEN, Square.E1);
	}
	
	@Test
	public void shouldFillRank7WithDarkPawnsWhenSettingUp() {
		verifyDarkPiecePlacedAt(PieceType.PAWN, Square.A7, Square.B7, Square.C7,
				Square.D7, Square.E7, Square.F7, Square.G7, Square.H7);
	}
	
	@Test
	public void shouldPlaceDarkRookAtA8AndH8WhenSettingUp() {
		verifyDarkPiecePlacedAt(PieceType.ROOK, Square.A8, Square.H8);
	}
	
	@Test
	public void shouldPlaceDarkKnightAtB8AndG8WhenSettingUp() {
		verifyDarkPiecePlacedAt(PieceType.KNIGHT, Square.B8, Square.G8);
	}
	
	@Test
	public void shouldPlaceDarkBishopAtC8AndF8WhenSettingUp() {
		verifyDarkPiecePlacedAt(PieceType.BISHOP, Square.C8, Square.F8);
	}
	
	@Test
	public void shouldPlaceDarkKingAtD8WhenSettingUp() {
		verifyDarkPiecePlacedAt(PieceType.KING, Square.D8);
	}
	
	@Test
	public void shouldPlaceDarkQueenAtE8WhenSettingUp() {
		verifyDarkPiecePlacedAt(PieceType.QUEEN, Square.E8);
	}
}