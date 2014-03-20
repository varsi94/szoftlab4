package Akadaly;

import Ellenseg.IEllenseg;
import Szkeleton.Main;

/**
 * Pokot reprezentáló osztály
 */
public class Pok extends AAkadaly {

	public Pok(int koltseg, int hatas) {
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
