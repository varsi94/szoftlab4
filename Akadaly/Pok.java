package Akadaly;

import Cella.Cella;
import Ellenseg.IEllenseg;

/**
 * Pokot reprezent�l� oszt�ly
 */
public class Pok extends AAkadaly {
	private static final int POK_KOLTSEG = 10;
	private static final int POK_HATAS = 1;

	public Pok(Cella c) {
		super(POK_KOLTSEG, POK_HATAS, c);
	}

	@Override
	public boolean akadalyoz(IEllenseg e) {
		System.out.println("P�k aktiv�l�dott: " + this.getCella().getY() + "," + this.getCella().getX());
		e.megall(2);
		return --hatas > 0;
	}

	@Override
	public void fejleszt() {
		hatas++;
	}
	
	@Override
	public String toString() {
		return "p�k";
	}
}
