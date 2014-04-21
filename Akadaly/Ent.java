package Akadaly;

import Cella.Cella;
import Ellenseg.IEllenseg;
import Prototipus.Kimenet;

/**
 * Entet reprezentáló osztály
 */
public class Ent extends AAkadaly {
	private static final long serialVersionUID = 2061085673027741014L;
	private static final int ENT_KOLTSEG = 30;
	private static final int ENT_HATAS = 3;

	public Ent(Cella c) {
		super(ENT_KOLTSEG, ENT_HATAS, c);
	}

	@Override
	public boolean akadalyoz(IEllenseg e) {
		Kimenet.akadalyAktivalodik(this);
		e.meghal();
		return --hatas > 0;
	}

	@Override
	public void fejleszt() {
		hatas++;
	}
	
	@Override
	public String toString() {
		return "Ent";
	}
}
