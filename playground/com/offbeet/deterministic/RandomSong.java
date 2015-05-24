package com.offbeet.deterministic;

import java.time.Duration;
import java.util.Random;

public class RandomSong implements ISong {

	@Override
	public int createNote(Random random) {
		return random.nextInt(7);
	}

	@Override
	public Duration createSilenceDuration(FleetingDataAndServices dataAndServices) {
		Random random = dataAndServices.random;
		return Duration.ofMillis(random.nextInt(2000));
	}

}
