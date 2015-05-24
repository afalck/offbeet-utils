package com.offbeet.deterministic;

public class Pat extends Command {

	private final SingingAnimal animal;
	
	public Pat(SingingAnimal animal) {
		this.animal = animal;
	}

	@Override
	public void execute() {
		animal.pat();
	}
	
	@Override
	public String toString(){
		return "Pat_" + animal.getClass().getSimpleName() + "_" + animal.name;
	}

}
