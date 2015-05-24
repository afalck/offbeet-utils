package com.offbeet.apps;

import java.util.Arrays;

import com.offbeet.deterministic.Application;
import com.offbeet.deterministic.Cat;
import com.offbeet.deterministic.Conductor;
import com.offbeet.deterministic.Dog;
import com.offbeet.deterministic.SingingAnimal;
import com.offbeet.deterministic.Tempo;
import com.offbeet.deterministic.songs.DoMiMi;
import com.offbeet.deterministic.songs.SolDoLaFa;

public class SingingPets extends Application {

	public static void main(String[] args) {
		
		Tempo tempo = new Tempo(200);
		SingingAnimal[] choire = { new Dog("Fluffy", new DoMiMi()), new Cat("Max", new SolDoLaFa())};
		Conductor conductor = setUpAndStart(tempo, choire);
		
		System.out.println("Started.");
		
		interactions(conductor, Arrays.asList(choire));
		
		System.out.println("End.");
		
	}

}
