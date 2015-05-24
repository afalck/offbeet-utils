package com.offbeet.deterministic;

import java.time.Duration;
import java.util.Random;

public class SheetMusic implements ISong {
	
	private final Note[] notes;
	private int current=-1;
	
	protected SheetMusic(Note[] notes){
		this.notes = notes;
	}

	private Note note() {
		return notes[current];
	}
	
	@Override
	public int createNote(Random random) {
		current = (current + 1) % notes.length;
		return note().tone;
	}

	@Override
	public Duration createSilenceDuration(FleetingDataAndServices dataAndServices) {
		Duration raw = dataAndServices.tempo.getDurationFor(note().quarters);
		return raw;
	}

}
