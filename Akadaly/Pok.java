package Akadaly;

import Cella.Cella;
import Ellenseg.IEllenseg;
import Szkeleton.Main;

/**
 * Pokot reprezentáló osztály
 */
public class Pok extends AAkadaly {

	public Pok(int koltseg, int hatas, Cella c) {
		super(koltseg, hatas, c);
		Main.log();
	}

	@Override
	public boolean akadalyoz(IEllenseg e) {
		Main.log();
		e.megall(this.hatas);
		return false;
	}

	@Override
	public void fejleszt() {
		Main.log();
	}

}
