package com.offbeet.deterministic;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.Test;

public class TestTempo {

	@Test
	public void test() {
		Tempo tempo = new Tempo(120);
		assertEquals("nominal duration of a quarter note", 500000000, tempo.nanosPerBeat, 0.1);
		assertEquals("actual duration of a quarter note",  Duration.ofMillis(495), tempo.getDurationFor(1));
	}

}
