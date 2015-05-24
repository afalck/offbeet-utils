package com.offbeet.deterministic;

public class ManualSeedGenerator extends SeedGenerator {

	private long nextSeed = Long.MIN_VALUE;

	@Override
	public long nextLong() {
		return nextSeed;
	}
	
	public void setSeed(long seed){
		nextSeed = seed;
	}

}
