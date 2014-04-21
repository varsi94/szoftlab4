package Akadaly;

import Cella.Cella;
import Ellenseg.IEllenseg;
import Prototipus.Kimenet;

/**
 * Entet reprezentáló osztály
 */
public class Ent extends AAkadaly {
	private static final long serialVersionUID = 2061085673027741014L;
	
	/**
	 * Az ent költsége.
	 */
	private static final int ENT_KOLTSEG = 30;
	
	/**
	 * Hány ellenségre tud hatni az ent.
	 */
	private static final int ENT_HATAS = 3;

	/**
	 * Konstrukor
	 * @param c A cella, amin áll az ent.
	 */
	public Ent(Cella c) {
		super(ENT_KOLTSEG, ENT_HATAS, c);
	}

	/**
	 * Akadályozó metódus
	 * @param e Az akadályozandó ellenség.
	 * @return True, ha még él, False, ha már nem
	 */
	@Override
	public boolean akadalyoz(IEllenseg e) {
		Kimenet.akadalyAktivalodik(this);
		e.meghal();
		return --hatas > 0;
	}

	/**
	 * Fejlesztõ metódus.
	 */
	@Override
	public void fejleszt() {
		hatas++;
	}
	
	/**
	 * Kiíratáshoz 
	 * @return "Ent"
	 */
	@Override
	public String toString() {
		return "Ent";
	}
}
