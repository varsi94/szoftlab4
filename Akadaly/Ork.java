package Akadaly;

import Ellenseg.IEllenseg;
import Szkeleton.Main;

/**
 * Orkot reprezentáló osztály
 */
public class Ork extends AAkadaly {

	public Ork(int koltseg, int hatas) {
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
