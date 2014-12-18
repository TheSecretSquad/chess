package com.disalvo.chess;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class DefaultPieceFactoryTest {

	private PieceFactory pieceFactory;
	
	private Color anyColor;
	@Before
	public void setUp() throws Exception {
		anyColor = Color.LIGHT;
		this.pieceFactory = new DefaultPieceFactory();
	}

	private void assertFactoryCreatesPieceType(PieceType pieceType, Class<?> clazz) {
		Piece piece = pieceFactory.createPiece(pieceType, anyColor);
		assertThat(piece, instanceOf(clazz));
	}
	
	@Test
	public void shouldReturnNewPawnWhenCreatingPawnType() {
		assertFactoryCreatesPieceType(PieceType.PAWN, Pawn.class);
	}
	
	@Test
	public void shouldReturnNewRookWhenCreatingRookType() {
		assertFactoryCreatesPieceType(PieceType.ROOK, Rook.class);
	}
	
	@Test
	public void shouldReturnNewKingWhenCreatingKingType() {
		assertFactoryCreatesPieceType(PieceType.KING, King.class);
	}
	
	@Test
	public void shouldReturnNewQueenWhenCreatingQueenType() {
		assertFactoryCreatesPieceType(PieceType.QUEEN, Queen.class);
	}
	
	@Test
	public void shouldReturnNewKnightWhenCreatingKnightType() {
		assertFactoryCreatesPieceType(PieceType.KNIGHT, Knight.class);
	}
	
	@Test
	public void shouldReturnNewBishopWhenCreatingBishopType() {
		assertFactoryCreatesPieceType(PieceType.BISHOP, Bishop.class);
	}
	
	@Test
	public void shouldReturnNewObjectsWhenMultipleCallsForSameType() {
		Piece p = pieceFactory.createPiece(PieceType.PAWN, Color.LIGHT);
		Piece p2 = pieceFactory.createPiece(PieceType.PAWN, Color.LIGHT);
		assertNotSame(p, p2);
	}
	
	@Test(expected=UnknownPieceTypeException.class)
	public void shouldThrowExceptionWhenNullPieceTypeGiven() {
		pieceFactory.createPiece(null, anyColor);
	}
}