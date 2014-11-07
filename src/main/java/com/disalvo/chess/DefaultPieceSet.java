package com.disalvo.chess;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class DefaultPieceSet implements PieceSet {
	
	private Map<Color, Map<PieceType, PiecePrototype>> pieces = new EnumMap<>(Color.class);
	{
		pieces.put(Color.LIGHT, new EnumMap<>(PieceType.class));
		pieces.put(Color.DARK, new EnumMap<>(PieceType.class));
	}
	
	@Override
	public void setupPieceTypeOfColorOnBoardAt(final PieceType pieceType, final Color color,
			final Board board, final Square... squares) {
		Arrays.asList(squares).forEach((Square s) -> {
			pieces.get(color).get(pieceType).newPieceOnBoardAt(board, s);
		});
	}
	
	public void registerPieceTypeOfColorWith(final PieceType pieceType, final Color color, final PiecePrototype piecePrototype) {
		pieces.get(color).put(pieceType, piecePrototype);
	}
}