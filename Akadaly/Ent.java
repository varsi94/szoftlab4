package Akadaly;

import Cella.Cella;
import Ellenseg.IEllenseg;

/**
 * Entet reprezent�l� oszt�ly
 */
public class Ent extends AAkadaly {

	private static final int ENT_KOLTSEG = 30;
	private static final int ENT_HATAS = 3;

	public Ent(Cella c) {
		super(ENT_KOLTSEG, ENT_HATAS, c);
	}

	@Override
	public boolean akadalyoz(IEllenseg e) {
		System.out.println("Ent aktiv�l�dott: " + this.getCella().getY() + "," + this.getCella().getX());
		e.meghal();
		return --hatas > 0;
	}

	@Override
	public void fejleszt() {
		hatas++;
	}
	
	@Override
	public String toString() {
		return "ent";
	}
}
