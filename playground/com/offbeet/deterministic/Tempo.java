package com.offbeet.deterministic;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalTime;

public class Tempo {
	private static final double FRACTION_TO_SLEEP = 0.9;
	private static final long NANOS_PER_MILLI = 1000000L;
	private static final long NANOS_PER_MINUTE = 60 * 1000L * NANOS_PER_MILLI;
	private static final int CLOCK_RESOLUTION_MILLIS = 10;
	private static final long SAFETY_NANOS = 5 * NANOS_PER_MILLI; //5 ms
	
	public final double nanosPerBeat;
	private final Duration cycleDuration;
	private final boolean shouldSleep;
	
	private LocalTime start = null;
	private long cycles = 0;
	
	public Tempo(int beatsPerMinute){
		this.nanosPerBeat = NANOS_PER_MINUTE/beatsPerMinute;
		long totalNanosPerCycle = (long) (nanosPerBeat / 8); //NOTE: we can play 1/32 notes.
		this.cycleDuration = Duration.ofNanos(totalNanosPerCycle);
		shouldSleep = CLOCK_RESOLUTION_MILLIS < cycleDuration.toMillis();
	}
	
	public Duration getDurationFor(double quarterNotes){
		long nanos = (long) (nanosPerBeat * quarterNotes);
		long roundedNanos = (nanos / 1000L) * 1000L;
		long sleep = roundedNanos - SAFETY_NANOS;
		return Duration.ofNanos(sleep);
	}

	public void start(Clock clock) {
		start = getStart(clock);
	}

	/*internal*/ static LocalTime getStart(Clock clock) {
		LocalTime now = LocalTime.now(clock);
		
		//Round the start to the next whole 10 second.
		//NOTE: we only do this because it makes it easier to debug... can be removed 
		int second = now.getSecond();
		long nanos = now.getNano();
		
		int nextRoundSecond = Math.round((second + 10) / 10) * 10;
		Duration roughDelta = Duration.ofSeconds(nextRoundSecond - second);
		Duration delta = roughDelta.minus(Duration.ofNanos(nanos));
		
		return now.plus(delta);
	}

	/**
	 * blocks the thread for enough time to keep the beet
	 */
	public void sleep(Clock clock) {

		LocalTime endSleep = nextEndSleepTime(clock);
		
		if (shouldSleep){
			sleep(cycleDuration);
		}
		
		while(LocalTime.now(clock).isBefore(endSleep)){
			//busy wait for up to 10 ms. (the clock resolution)
		}
	}

	private static void sleep(Duration cycleDuration) {
		try {
			long millis = Math.round((cycleDuration.toMillis() * FRACTION_TO_SLEEP));
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * NOTE that we keep time based on a multiple of the cycle duration anchored at the start time.
	 * We don't simply try to sleep for a certain duration because that will drift over time.
	 * 
	 * @param clock
	 * @return
	 */
	private LocalTime nextEndSleepTime(Clock clock) {
		LocalTime returnValue = LocalTime.MIN;
		//NOTE: this loop ensures that we synch up if we miss a cycle.
		//      It is especially useful at the start of the application (if it is already several cycles past the start)
		//      we do assume that we didn't miss too much time.
		while (!returnValue.isAfter(LocalTime.now(clock))){
			returnValue = start.plus(cycleDuration.multipliedBy(cycles++));
		}
		return returnValue;
	}

}
