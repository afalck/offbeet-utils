package com.offbeet.apps;

import java.util.Arrays;

import com.offbeet.deterministic.Application;
import com.offbeet.deterministic.Cat;
import com.offbeet.deterministic.Conductor;
import com.offbeet.deterministic.ISong;
import com.offbeet.deterministic.RandomSong;
import com.offbeet.deterministic.SingingAnimal;
import com.offbeet.deterministic.Tempo;

public class RandomCats extends Application {

	public static void main(String[] args) {
		
		Tempo tempo = new Tempo(634);
		ISong song = new RandomSong();
		SingingAnimal[] choire = { new Cat("Max", song)};
		Conductor conductor = setUpAndStart(tempo, choire);
		
		System.out.println("Started.");
		
		interactions(conductor, Arrays.asList(choire));
		
		System.out.println("End.");
		
	}

}
