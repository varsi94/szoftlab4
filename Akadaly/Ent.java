package Akadaly;

import Cella.Cella;
import Ellenseg.IEllenseg;

/**
 * Entet reprezentáló osztály
 */
public class Ent extends AAkadaly {

	private static final int ENT_KOLTSEG = 30;
	private static final int ENT_HATAS = 3;

	public Ent(Cella c) {
		super(ENT_KOLTSEG, ENT_HATAS, c);
	}

	@Override
	public boolean akadalyoz(IEllenseg e) {
		e.meghal();
		return --hatas > 0;
	}

	@Override
	public void fejleszt() {
		hatas += 3;
	}

}
