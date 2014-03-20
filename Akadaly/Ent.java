package Akadaly;

import Ellenseg.IEllenseg;
import Szkeleton.Main;

/**
 * Entet reprezentáló osztály
 */
public class Ent extends AAkadaly {

	public Ent(int koltseg, int hatas) {
		super(koltseg, hatas);
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
