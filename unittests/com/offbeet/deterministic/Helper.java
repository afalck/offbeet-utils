package com.offbeet.deterministic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;

import com.offbeet.deterministic.FleetingDataAndServices.Factory;

class Helper{
	private final Conductor conductor;
	private final Tempo tempo;
	private final ManualClock clock;
	private final ManualSeedGenerator generator;
	private final Factory fleetingfactory;
	
	private FleetingDataAndServices cycleFleetingDataAndServices = null;
	
	public Helper(Conductor conductor, Tempo tempo, ManualClock clock, ManualSeedGenerator generator, Factory fleetingfactory) {
		this.conductor = conductor;
		this.tempo = tempo;
		this.clock = clock;
		this.generator = generator;
		this.fleetingfactory = fleetingfactory;
	}

	public void emulateDataAndServices(long time, long randomSeed, Command[] commands) {
		assert(cycleFleetingDataAndServices == null); //fail fast if we accidentally call emulateDataAndServices again.
		
		clock.setTimeInMillis(time);
		generator.setSeed(randomSeed);
		cycleFleetingDataAndServices = fleetingfactory.next(Arrays.asList(commands), tempo);

		conductor.hook_processCycle(cycleFleetingDataAndServices);
	}

	public void assertSang(String[] expected) {
		assert(cycleFleetingDataAndServices != null); //fail fast if we accidentally call assertSang again.

		List<String> actual = ((Auditor) cycleFleetingDataAndServices.auditor).getData();
		String message = "Expected: "+Arrays.asList(expected)+" but received: "+actual;
		Iterator<String>data = actual.iterator();
		for (String string : expected) {
			Assert.assertTrue(message, data.hasNext());
			Assert.assertEquals(message, string, data.next());
		}
		Assert.assertFalse(message, data.hasNext());
		
		cycleFleetingDataAndServices = null; //fail fast if we accidentally call assertSang again.
	}
	
}