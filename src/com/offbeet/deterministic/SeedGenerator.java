package com.offbeet.deterministic;

import java.util.Random;

public abstract class SeedGenerator {

	public abstract long nextLong();
	

	
	public static class SystemRandomGenerator extends SeedGenerator {
		private Random random = new Random();
		
		@Override
		public long nextLong() {
			return random.nextLong();
		}
	}


	public static SeedGenerator systemRandom() {
		return new SystemRandomGenerator();
	}
}
