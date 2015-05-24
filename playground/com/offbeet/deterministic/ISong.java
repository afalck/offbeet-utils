package com.offbeet.deterministic;

import java.time.Duration;
import java.util.Random;

public interface ISong {

	int createNote(Random random);
	Duration createSilenceDuration(FleetingDataAndServices dataAndServices);

}
