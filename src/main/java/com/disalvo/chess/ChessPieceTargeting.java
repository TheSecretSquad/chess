package com.disalvo.chess;

public interface ChessPieceTargeting {
	
	/**
	 * <p>Target available spaces in a forward path the maximum number of spaces
	 * equal to {@code maxTargetingCount}.</p>
	 * 
	 * <p>A path includes valid intermediate spaces as targets. Valid spaces are empty.
	 * Obstacles met before reaching the max count will block the path,
	 * but targets include valid spaces up to the obstacle.</p>
	 * 
	 * @param maxCountIfNeverMoved Maximum path count if piece never moved.
	 * @param maxCountIfHasMoved Maximum path count if piece has moved.
	 */
	void pathForward(final TargetingCount maxTargetingCount);
	
	/**
	 * <p>Attack the space in the forward-right direction. Target is valid
	 * only if an attack is available.</p>
	 */
	void attackForwardRight();
	
	/**
	 * <p>Attack the space in the forward-left direction. Target is valid
	 * only if an attack is available.</p>
	 */
	void attackForwardLeft();
}