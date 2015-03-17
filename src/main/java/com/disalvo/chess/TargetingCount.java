package com.disalvo.chess;

public final class TargetingCount {

	private final int value;
	
	public TargetingCount(final int value)
	{
		if(value < 0)
			throw new NegativeTargetingCountException();
		
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TargetingCount other = (TargetingCount) obj;
		if (value != other.value)
			return false;
		return true;
	}
}