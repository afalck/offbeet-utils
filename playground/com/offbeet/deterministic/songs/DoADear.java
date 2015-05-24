package com.offbeet.deterministic.songs;

import com.offbeet.deterministic.Note;
import com.offbeet.deterministic.SheetMusic;

public class DoADear extends SheetMusic {

	public DoADear() {
		super(new Note[]{
				Note.q.dot().DO, Note.e.RE, Note.q.dot().MI, Note.e.DO, Note.q.MI, Note.q.DO, Note.h.MI,
				Note.q.dot().RE, Note.e.MI, Note.e.FA, Note.e.FA, Note.e.MI, Note.e.RE, Note.w.FA,
				Note.q.dot().MI, Note.e.FA, Note.q.dot().SOL, Note.e.MI, Note.q.SOL, Note.q.MI, Note.h.SOL,
				Note.q.dot().FA, Note.e.SOL, Note.e.LA, Note.e.LA, Note.e.SOL, Note.e.FA, Note.w.LA,
				
				Note.q.dot().SOL, Note.e.DO, Note.e.RE, Note.e.MI, Note.e.FA, Note.e.SOL, Note.w.LA, 
				Note.q.dot().LA,  Note.e.RE, Note.e.MI, Note.e.FA, Note.e.SOL, Note.e.LA, Note.w.SI, 
				Note.q.dot().SI,  Note.e.MI, Note.e.FA, Note.e.SOL, Note.e.LA, Note.e.SI, Note.h.dot().DO2, //next octave
				
				Note.e.DO2, Note.e.SI, Note.q.LA, Note.q.FA, Note.q.SI, Note.q.SOL, 
				Note.q.DO2, Note.q.SOL, Note.q.MI, Note.q.RE, 
		});
	}

	
}
