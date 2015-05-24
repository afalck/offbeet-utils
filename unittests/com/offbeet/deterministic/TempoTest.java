package com.offbeet.deterministic;

import static org.junit.Assert.*;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;

import junit.framework.Assert;

import org.junit.Test;

public class TempoTest {

	@Test
	public void test_start() {
		{
			Instant timeStarted = Instant.ofEpochMilli(50);
			Instant expectedTime = Instant.ofEpochSecond(10);
			assertStartIsRoundedCorrectly(expectedTime, timeStarted);			
		}
		{
			Instant timeStarted = Instant.ofEpochMilli(10050);
			Instant expectedTime = Instant.ofEpochSecond(20);
			assertStartIsRoundedCorrectly(expectedTime, timeStarted);			
		}
		{
			Instant timeStarted = Instant.ofEpochMilli(10000);
			Instant expectedTime = Instant.ofEpochSecond(20);
			assertStartIsRoundedCorrectly(expectedTime, timeStarted);			
		}
	}

	private void assertStartIsRoundedCorrectly(Instant expectedTime,
			Instant timeStarted) {
		Clock clock = Clock.fixed(timeStarted, ZoneId.systemDefault());	
		LocalTime start = Tempo.getStart(clock);
		
		LocalTime expected = LocalTime.now(Clock.fixed(expectedTime, ZoneId.systemDefault()));
		assertEquals("should be a round multiple of 10 seconds", expected , start);
	}

}
