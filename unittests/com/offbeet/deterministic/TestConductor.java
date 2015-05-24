package com.offbeet.deterministic;

import java.time.ZoneId;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import com.offbeet.deterministic.FleetingDataAndServices.Factory;

public class TestConductor {

	private static final LinkedList<Command> EMPTY = new LinkedList<Command>();

	@Test
	public void test() {
		ManualClock clock = new ManualClock(ZoneId.systemDefault());
		ManualSeedGenerator generator = new ManualSeedGenerator();
		Factory fleetingfactory = new FleetingDataAndServices.Factory(clock, generator);
		Tempo tempo = new Tempo(120);
		ISong song = new RandomSong();
		SingingAnimal[] choire = { new Dog("", song), new Cat("", song)};

		Conductor c = new Conductor(fleetingfactory, choire, tempo);
		
		{
			clock.setTimeInMillis(1427207888831L);
			generator.setSeed(1735849225594680355L);
			FleetingDataAndServices fleetingDataAndServices = fleetingfactory.next(EMPTY, tempo);
			c.hook_processCycle(fleetingDataAndServices);
			Iterator<String> data = ((Auditor) fleetingDataAndServices.auditor).getData().iterator();
			Assert.assertEquals("woof 6", data.next());
			Assert.assertEquals("meow 0", data.next());
		}
		
		{
			clock.setTimeInMillis(1427207889035L);
			generator.setSeed(146802254858989398L);
			c.hook_processCycle(fleetingfactory.next(EMPTY, tempo));
			Assert.assertTrue(true);
		}
		
		{
			clock.setTimeInMillis(1427207889240L);
			generator.setSeed(8579462096791133353L);
			c.hook_processCycle(fleetingfactory.next(EMPTY, tempo));
			Assert.assertTrue(true);
		}
	}

}
