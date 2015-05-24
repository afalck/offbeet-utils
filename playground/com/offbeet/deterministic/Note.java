package com.offbeet.deterministic;

public class Note {

	
	
	public final int tone;
	public final double quarters;
	
	public Note(int tone, double quarters){
		this.tone = tone;
		this.quarters = quarters;
	}
	
	/**
	 * Quaver / Eighth note
	 */
	public static NoteBuilder e = new NoteBuilder(0.5); 
	
	/**
	 * Crotchet / Quarter note
	 */
	public static NoteBuilder q = new NoteBuilder(1);  
	
	/**
	 * Minim / Half note
	 */
	public static NoteBuilder h = new NoteBuilder(2);
	
	/**
	 * Semibreve / Whole note
	 */
	public static NoteBuilder w = new NoteBuilder(4);
	
	
	
	
	public static class NoteBuilder{
		private final double quaters;
		
		public final Note DO;
		public final Note RE;
		public final Note MI;
		public final Note FA;
		public final Note SOL;
		public final Note LA;
		public final Note SI;
		public final Note DO2;
		public final Note RE2;

		public NoteBuilder(double quaters) {
			this.quaters = quaters;
			
			DO = new Note(0, quaters);
			RE = new Note(1, quaters);
			MI = new Note(2, quaters);
			FA = new Note(3, quaters);
			SOL = new Note(4, quaters);
			LA = new Note(5, quaters);
			SI = new Note(6, quaters);
			DO2 = new Note(7, quaters);
			RE2 = new Note(8, quaters);
		}

		public NoteBuilder dot(){
			return 	new NoteBuilder(quaters * 1.5);
		}
		
	}
}
