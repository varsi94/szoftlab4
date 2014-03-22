package Akadaly;

import Cella.Cella;
import Ellenseg.IEllenseg;
import Szkeleton.Main;

/**
 * Entet reprezentáló osztály
 */
public class Ent extends AAkadaly {

	public Ent(int koltseg, int hatas, Cella c) {
		super(koltseg, hatas, c);
		Main.log();
	}

	@Override
	public boolean akadalyoz(IEllenseg e) {
		Main.log();
		return false;
	}

	@Override
	public void fejleszt() {
		Main.log();
	}

}
