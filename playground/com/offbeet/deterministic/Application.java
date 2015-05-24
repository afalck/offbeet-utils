package com.offbeet.deterministic;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.Clock;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

	private static final char PAT_A_DOG = 'd';
	private static final char PAT_A_CAT = 'c';


	protected static Conductor setUpAndStart(Tempo tempo, SingingAnimal[] choire) {
		Clock clock = Clock.systemDefaultZone();		
		SeedGenerator generator = SeedGenerator.systemRandom();
		FleetingDataAndServices.Factory fleetingfactory = new FleetingDataAndServices.Factory(clock, generator );		

		Conductor conductor = new Conductor(fleetingfactory, choire, tempo);
		Thread t = new Thread(conductor);
		t.setName("Conductor Thread");
		t.setDaemon(true);
		t.start();
		return conductor;
	}

	protected static void interactions(Conductor conductor, List<SingingAnimal> choire) {
		try {
			int i = 0;
			boolean stop = false;
			while(!stop){
				Reader reader = new InputStreamReader(System.in);
				char command = (char) reader.read();
				i++;
				
				switch (command){
					case PAT_A_DOG:
						SingingAnimal dog = choose(Dog.class, choire, i);
						conductor.pat(dog);
						break;
					case PAT_A_CAT:
						SingingAnimal cat = choose(Cat.class, choire, i);
						conductor.pat(cat);
						break;
					default:
						stop = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static SingingAnimal choose(Class class1, List<SingingAnimal> choire, int i){
		List<SingingAnimal> filtered = choire.stream().filter(a -> class1.isInstance(a)).collect(Collectors.toList());
		int which = i % filtered.size();
		return filtered.get(which);
	}

}
