package com.disalvo.chess;

public interface PieceTargeting {
	
	/**
	 * <p>Target available spaces in a forward path the maximum number of spaces
	 * equal to {@code maxCountIfNeverMoved} if the piece has never moved, or
	 * {@code maxCountIfHasMoved} if the piece has moved at least once.</p>
	 * 
	 * <p>A path includes valid intermediate spaces as targets.
	 * Targeting assumes empty squares. Obstacles met before the max count is
	 * reached will block the path, but include valid spaces up to the obstacle.</p>
	 * 
	 * @param maxCountIfNeverMoved Maximum path count if piece never moved.
	 * @param maxCountIfHasMoved Maximum path count if piece has moved.
	 */
	void pathForward(final TargetingCount maxCountIfNeverMoved, final TargetingCount maxCountIfHasMoved);
	
	/**
	 * 
	 *<p>Target available spaces in a forward path the maximum number of spaces
	 * equal to {@code maxCountIfNeverMoved} if the piece has never moved, or
	 * {@code maxCountIfHasMoved} if the piece has moved at least once.</p>
	 * 
	 * <p>A path includes valid intermediate spaces as targets.
	 * Targeting assumes empty squares. Obstacles met before the max count is
	 * reached will block the path, but include valid spaces up to the obstacle.</p>
	 * 
	 * @param rankDirection The rank-wise direction.
	 * @param fileDirection The file-wise direction.
	 * @param maxCountIfNeverMoved Maximum path count if piece never moved.
	 * @param maxCountIfHasMoved Maximum path count if piece has moved.
	 */
	void path(
			final RankDirection rankDirection, final FileDirection fileDirection,
			final TargetingCount maxCountIfNeverMoved, final TargetingCount maxCountIfHasMoved);
	
	void path(
			final RankDirection rankDirection, final TargetingCount maxCountIfNeverMoved, final TargetingCount maxCountIfHasMoved);
	
	void path(
			final FileDirection fileDirection, final TargetingCount maxCountIfNeverMoved, final TargetingCount maxCountIfHasMoved);

	void attack(final RankDirection rankDirection, final FileDirection fileDirection);
}