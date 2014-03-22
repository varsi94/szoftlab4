package Akadaly;

import Cella.Cella;
import Ellenseg.IEllenseg;
import Szkeleton.Main;

/**
 * Orkot reprezentáló osztály
 */
public class Ork extends AAkadaly {

	public Ork(int koltseg, int hatas, Cella c) {
		super(koltseg, hatas, c);
		Main.log();
	}

	@Override
	public boolean akadalyoz(IEllenseg e) {
		Main.log();
		e.meghal();
		if (Main.currSzekvencia == 14)
			cella.setAkadaly(null);
		return false;
	}

	@Override
	public void fejleszt() {
		Main.log();
		hatas++;
	}

}
