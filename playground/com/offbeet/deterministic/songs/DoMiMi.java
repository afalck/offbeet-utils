package com.offbeet.deterministic.songs;

import com.offbeet.deterministic.Note;
import com.offbeet.deterministic.SheetMusic;

public class DoMiMi extends SheetMusic {

	public DoMiMi() {
		super(new Note[]{
				Note.q.DO, Note.q.MI,  Note.h.MI,
				Note.q.MI, Note.q.SOL, Note.h.SOL,
				Note.q.RE, Note.q.FA,  Note.h.FA,
				Note.q.LA, Note.q.SI,  Note.h.SI,
		});
	}

	
}
