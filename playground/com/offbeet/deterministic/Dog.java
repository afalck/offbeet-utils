package com.offbeet.deterministic;

import java.io.File;

import javax.sound.sampled.Clip;

public class Dog extends SingingAnimal {
	
	private final Clip[] sounds = new Clip[9];
	
	public Dog(String name, ISong song){
		super(name, song);
		
	    sounds[0] = loadClip(new File("playground/com/offbeet/deterministic/dog_bark_c.wav"));
	    sounds[1] = loadClip(new File("playground/com/offbeet/deterministic/dog_bark_d.wav"));
	    sounds[2] = loadClip(new File("playground/com/offbeet/deterministic/dog_bark_e.wav"));
	    sounds[3] = loadClip(new File("playground/com/offbeet/deterministic/dog_bark_f.wav"));
	    sounds[4] = loadClip(new File("playground/com/offbeet/deterministic/dog_bark_g.wav"));
	    sounds[5] = loadClip(new File("playground/com/offbeet/deterministic/dog_bark_a.wav"));
	    sounds[6] = loadClip(new File("playground/com/offbeet/deterministic/dog_bark_b.wav"));

	    sounds[7] = loadClip(new File("playground/com/offbeet/deterministic/dog_bark_c2.wav"));
	    sounds[8] = loadClip(new File("playground/com/offbeet/deterministic/dog_bark_d2.wav"));

	}
	
	public String bark(int note){
		Clip sound = sounds[note];
		sound.stop();
		sound.drain(); // in case the previous time we played this note is still playing it.
		
		sound.setFramePosition(0);
		sound.start();

		String message = "woof " + note;
		return message;
	}

	@Override
	protected String singNote(int note) {
		return bark(note);
	}

}
