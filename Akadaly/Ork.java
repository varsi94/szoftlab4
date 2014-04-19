package Akadaly;

import Cella.Cella;
import Ellenseg.IEllenseg;

/**
 * Orkot reprezentáló osztály
 */
public class Ork extends AAkadaly {

	private static final int ORK_KOLTSEG = 20;
	private static final int ORK_HATAS = 1;

	public Ork(Cella c) {
		super(ORK_KOLTSEG, ORK_HATAS, c);
	}

	@Override
	public boolean akadalyoz(IEllenseg e) {
		System.out.println("Ork aktiválódott: " + this.getCella().getY() + "," + this.getCella().getX());
		e.meghal();
		return --hatas > 0;
	}

	@Override
	public void fejleszt() {
		hatas++;
	}
	
	@Override
	public String toString() {
		return "ork";
	}
}
