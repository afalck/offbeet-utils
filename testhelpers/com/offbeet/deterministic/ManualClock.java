package com.offbeet.deterministic;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class ManualClock extends Clock {

	private final ZoneId zone;
	private Instant nextInstant = Instant.MIN;	
	
	public ManualClock(ZoneId zone){
		this.zone = zone;
	}
	
	@Override
	public ZoneId getZone() {
		return zone;
	}

	@Override
	public Clock withZone(ZoneId zone) {
		return new ManualClock(zone);
	}

	@Override
	public Instant instant() {
		return nextInstant;
	}

	public void setTimeInMillis(long epochMilli){
		nextInstant = Instant.ofEpochMilli(epochMilli);
	}
}
