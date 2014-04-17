package Akadaly;

import Cella.Cella;
import Ellenseg.IEllenseg;

/**
 * Pokot reprezentáló osztály
 */
public class Pok extends AAkadaly {
	private static final int POK_KOLTSEG = 10;
	private static final int POK_HATAS = 2;

	public Pok(Cella c) {
		super(POK_KOLTSEG, POK_HATAS, c);
	}

	@Override
	public boolean akadalyoz(IEllenseg e) {
		e.megall(this.hatas);
		return --hatas > 0;
	}

	@Override
	public void fejleszt() {
		hatas += 3;
	}

}
