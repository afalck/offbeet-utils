package com.offbeet.deterministic;

import java.time.Clock;
import java.util.List;
import java.util.Random;

import com.offbeet.utils.ToStringBuilder;

public class FleetingDataAndServices {
	public final Clock clock;
	public final Random random;
	public final IAuditor auditor;
	public final List<Command> commands;
	public final Tempo tempo;
	
	private final long randomSeed;
	
	private FleetingDataAndServices(Clock clock, long randomSeed, List<Command> commands, Auditor auditor, Tempo tempo){
		this.randomSeed = randomSeed;
		random = new Random(randomSeed);
		this.clock = Clock.fixed(clock.instant(), clock.getZone());
		this.commands = commands;
		this.auditor = auditor;
		this.tempo = tempo;
	}

	@Override
	public String toString(){
		return ToStringBuilder.forObject(this)
				.add("clock", clock.millis())
				.add("randomSeed", randomSeed)
				.add("tempo", tempo)
				.add("commands", commands)
				.toString();
	}
	public String simplifiedString() {
		return String.format("%sL, %sL, %s", 
				clock.millis(), 
				randomSeed, 
				simplifiedString(commands));
	}
	
	
	
	
	private String simplifiedString(List<Command> commands2) {
		StringBuilder b = new StringBuilder();
		b.append("new Command[]{");
		for (Command command : commands2) {
			b.append(command);
			b.append(',');
		}
		if (!commands2.isEmpty()){
			b.deleteCharAt(b.length() - 1);
		}
		b.append('}');
		return b.toString();
	}




	public static class Factory{
		private final Clock clock;
		private final SeedGenerator generator;
		
		public Factory(Clock clock, SeedGenerator generator){
			this.clock = clock;
			this.generator = generator;
		}
		
		public FleetingDataAndServices next(List<Command> commands, Tempo tempo){
			return new FleetingDataAndServices(clock, generator.nextLong(), commands, new Auditor(), tempo);
		}
	}




}
