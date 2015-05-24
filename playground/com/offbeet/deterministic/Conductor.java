package com.offbeet.deterministic;

import java.time.Clock;
import java.time.LocalTime;
import java.util.List;


public class Conductor implements Runnable {

	private final FleetingDataAndServices.Factory fleetingfactory;
	private final CommandManager commandManager = new CommandManager();
	private final SingingAnimal[] choire;
	private final Tempo tempo;
	
	private boolean stopped = false;
	
	public Conductor(FleetingDataAndServices.Factory fleetingfactory, SingingAnimal[] choire, Tempo tempo){
		this.fleetingfactory = fleetingfactory;
		this.choire = choire;
		this.tempo = tempo;
	}
	
	public void stop(){
		stopped = true;
	}
	
	public void run(){
		Clock clock = Clock.systemDefaultZone();
		tempo.start(clock);
		while (!stopped) {
			tempo.sleep(clock);
			processCycle();
		}
	}

	public void pat(SingingAnimal animal) {
		commandManager.add(new Pat(animal));
	}


	private void internalProcessCycle(FleetingDataAndServices dataAndServices) {
		List<Command> commands = dataAndServices.commands;
		for (Command command : commands) {
			command.execute();
		}
		
		for (SingingAnimal animal : choire) {
			animal.continueSinging(dataAndServices);
		}
	}
	
	private void processCycle() {
		List<Command> commands = commandManager.processAll();
		FleetingDataAndServices dataAndServices = fleetingfactory.next(commands, tempo);
		internalProcessCycle(dataAndServices);		
		logIfSignificant(commands, dataAndServices);	
	}

	private void logIfSignificant(List<Command> commands, FleetingDataAndServices dataAndServices) {
		if (commands.isEmpty() && dataAndServices.auditor.isEmpty()){
			return; //nothing to report
		}
		
		System.out.println(String.format("h.emulateDataAndServices(%s);", dataAndServices.simplifiedString()));
		System.out.println(String.format("h.assertSang(new String[]%s);", dataAndServices.auditor));
		System.out.println();
	}
	
	/*package*/ void hook_processCycle(FleetingDataAndServices dataAndServices) {
		internalProcessCycle(dataAndServices);
	}

}
