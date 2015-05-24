package com.offbeet.badcode;

import java.time.Clock;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

class BadCode {
	
	private static final Date DEADLINE = new Date(2015, 06, 10, 9, 30);

	public void badRandom(){
		Random die = new Random();
		int roll = die.nextInt(6);
		switch(roll){
			case 0:  //do something
			case 1:  //do something
			case 2:  //do something
			case 3:  //do something
			case 4:  //do something
			case 5:  //do something
			default:
				throw new IllegalArgumentException("cannot happen: " + roll);
		}
	}

	public void badMethod(){
		Date now = new Date();
		if (DEADLINE.before(now)){
			//do something...
		}
	}
}

class BetterCode{
	
	private static final LocalTime DEADLINE = LocalTime.of(9, 30);

	public void betterMethod(){
		LocalTime now = LocalTime.now();
		if (DEADLINE.isBefore(now)){
			//do something...
		}		
	}
}

class BestCode{
	
	private static final LocalTime DEADLINE = LocalTime.of(9, 30);

	public void bestMethod(Clock clock){
		LocalTime now = LocalTime.now(clock);
		if (DEADLINE.isBefore(now)){
			//do something...
		}		
	}
}


