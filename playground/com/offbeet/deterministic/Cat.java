package com.offbeet.deterministic;

import java.io.File;

import javax.sound.sampled.Clip;

public class Cat extends SingingAnimal {

	private final File[] sounds = new File[9];
	
	public Cat(String name, ISong song){
		super(name, song);

	    sounds[0] = new File("playground/com/offbeet/deterministic/cat_meow_c.wav");
	    sounds[1] = new File("playground/com/offbeet/deterministic/cat_meow_d.wav");
	    sounds[2] = new File("playground/com/offbeet/deterministic/cat_meow_e.wav");
	    sounds[3] = new File("playground/com/offbeet/deterministic/cat_meow_f.wav");
	    sounds[4] = new File("playground/com/offbeet/deterministic/cat_meow_g.wav");
	    sounds[5] = new File("playground/com/offbeet/deterministic/cat_meow_a.wav");
	    sounds[6] = new File("playground/com/offbeet/deterministic/cat_meow_b.wav");

	    sounds[7] = new File("playground/com/offbeet/deterministic/cat_meow_c2.wav");
	    sounds[8] = new File("playground/com/offbeet/deterministic/cat_meow_d2.wav");

	}
	
	public String meow(int note){
		Clip sound = loadClip(sounds[note]);
		
		sound.setFramePosition(0);
		sound.start();

		String message = "meow " + note;
		return message;
	}

	@Override
	protected String singNote(int note) {
		return meow(note);
	}

}
