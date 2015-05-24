package com.offbeet.deterministic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public abstract class SingingAnimal {
	
	private static final Duration CALMING_DURATION = Duration.ofSeconds(3);
	
	public final String name;
	private final ISong song;

	private LocalTime silenceEndTime = LocalTime.MIN;


	public SingingAnimal(String name, ISong song) {
		this.name = name;
		this.song = song;
	}

	public boolean isQuiet(LocalTime now) {
		return now.isBefore(silenceEndTime); 
	}

	public void pat() {
		silenceEndTime = silenceEndTime.plus(CALMING_DURATION);		
	}

	public void continueSinging(FleetingDataAndServices fleetingDataAndServices){
		if (isQuiet(LocalTime.now(fleetingDataAndServices.clock))){
			return;
		}

		int note = song.createNote(fleetingDataAndServices.random);
		String sang = singNote(note);
		
		Duration silenceDuration = song.createSilenceDuration(fleetingDataAndServices);
		silenceEndTime = LocalTime.now(fleetingDataAndServices.clock).plus(silenceDuration );
		
		fleetingDataAndServices.auditor.add(sang);
	}

	protected abstract String singNote(int note);
	
	protected void playClip(Clip clip){
	    // play the sound clip
	    clip.start();	
	}
	
	protected static Clip loadClip(File soundFile){
			try {
				return doLoadClip(soundFile);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	}
	
	protected static Clip doLoadClip(File soundFile) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
	    AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);

	    // load the sound into memory (a Clip)
	    DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
	    Clip clip = (Clip) AudioSystem.getLine(info);
	    clip.open(sound);

	    return clip;
	}
}
