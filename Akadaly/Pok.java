package Akadaly;

import Cella.Cella;
import Ellenseg.IEllenseg;
import Prototipus.Kimenet;

/**
 * Pokot reprezentáló osztály
 */
public class Pok extends AAkadaly {
	private static final long serialVersionUID = -3619434867885153060L;
	private static final int POK_KOLTSEG = 10;
	private static final int POK_HATAS = 1;

	public Pok(Cella c) {
		super(POK_KOLTSEG, POK_HATAS, c);
	}

	@Override
	public boolean akadalyoz(IEllenseg e) {
		if (e.getKimarad() != 1 || e.isLassitott())
			return true;
		else {
			Kimenet.akadalyAktivalodik(this);
			e.megall(2);
			return --hatas > 0;
		}
	}

	@Override
	public void fejleszt() {
		hatas++;
	}

	@Override
	public String toString() {
		return "Pók";
	}
}
