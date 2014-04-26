package Akadaly;

import Cella.Cella;
import Ellenseg.IEllenseg;

/**
 * Az akadályt implementáló absztrakt osztály
 * 
 */
public abstract class AAkadaly implements IAkadaly {
	private static final long serialVersionUID = 1390074678693050108L;
	/**
	 * Ez az attribútum tárolja hogy hány ellenségre tudja végrehajtani a képességét mielõtt eltûnik.
	 */
	protected int hatas;

	/**
	 * Ez az attribútum tárolja az aktuális cellát;
	 */
	protected Cella cella;

	/**
	 * Konstruktor
	 */
	public AAkadaly(int hatas, Cella c) {
		this.hatas = hatas;
		this.cella = c;
	}

	/**
	 * Akadályozó metódus
	 * 
	 * @param e
	 *            az akadályozandó ellenség
	 * @return True, ha még él az akadály, false, ha nem
	 */
	@Override
	public abstract boolean akadalyoz(IEllenseg e);

	/**
	 * Fejlesztési metódus
	 */
	@Override
	public abstract void fejleszt();

	/**
	 * A cellát lekérdezõ metódus.
	 * 
	 * @return Azt a cellát adja vissza, amelyiken az akadály áll.
	 */
	@Override
	public final Cella getCella() {
		return cella;
	}

	/**
	 * Hatást lekérdezõ metódus.
	 * 
	 * @return Még hány ellenségre tud hatni az akadály.
	 */
	@Override
	public final int getHatas() {
		return hatas;
	}

}
