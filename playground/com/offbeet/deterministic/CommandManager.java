package com.offbeet.deterministic;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * A simple producer-consumer manager.
 * 
 * WARNING: this is a naive implementation.
 * There is no limit to the size of the queue.
 * 
 * @author arturofalck
 */

/** WARNING: do not use as synchronization monitor */
public class CommandManager {
	
	private List<Command> commandsForNextCycle = new LinkedList<Command>();

	public synchronized void add(Command command) {
		commandsForNextCycle.add(command);
	}

	public synchronized List<Command> processAll() {
		List<Command> commandsToReturn = commandsForNextCycle;
		//cutoff:  from this point on, we are collecting commands for the next cycle.
		commandsForNextCycle = new LinkedList<Command>(); 
		return commandsToReturn;
	}
}
