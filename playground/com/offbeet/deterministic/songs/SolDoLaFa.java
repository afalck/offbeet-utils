package com.offbeet.deterministic.songs;

import com.offbeet.deterministic.Note;
import com.offbeet.deterministic.SheetMusic;

public class SolDoLaFa extends SheetMusic {

	public SolDoLaFa() {
		super(new Note[]{
				Note.h.SOL, Note.h.DO, Note.h.LA, Note.h.FA, Note.h.MI,  Note.h.DO,  Note.w.RE,
				Note.h.SOL, Note.h.DO, Note.h.LA, Note.h.SI, Note.h.DO2, Note.h.RE2, Note.w.DO2
				});
	}

	
}
