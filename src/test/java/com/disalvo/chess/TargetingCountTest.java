package com.disalvo.chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TargetingCountTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test(expected=NegativeTargetingCountException.class)
	public void shouldThrowExceptionWhenInitializedWithNegativeValue() {
		new TargetingCount(-1);
	}
	
	@Test
	public void shouldBeEqualWhenComparingDifferentObjectsOfSameValue() {
		assertTrue(new TargetingCount(1).equals(new TargetingCount(1)));
	}
	
	@Test
	public void shouldBeUnEqualWhenComparingDifferentObjectsOfSameValue() {
		assertFalse(new TargetingCount(1).equals(new TargetingCount(2)));
	}

	@Test
	public void shouldBeEqualWhenComparingSameObject() {
		TargetingCount tc = new TargetingCount(1);
		TargetingCount tc2 = tc;
		assertTrue(tc.equals(tc2));
		assertTrue(tc2.equals(tc));
	}
}