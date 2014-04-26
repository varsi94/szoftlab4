package Akadaly;

import java.awt.Color;

import Cella.Cella;
import Ellenseg.IEllenseg;

/**
 * Pokot reprezentáló osztály
 */
public class Pok extends AAkadaly {
	private static final long serialVersionUID = -3619434867885153060L;

	/**
	 * Pók költsége
	 */
	public static final int KOLTSEG = 50;

	/**
	 * Pók default hatása
	 */
	private static final int POK_HATAS = 1;

	/**
	 * Konstrukor
	 * 
	 * @param c
	 *            A cella, ahol a pók áll.
	 */
	public Pok(Cella c) {
		super(POK_HATAS, c);
	}

	/**
	 * Akadályozó metódus
	 * 
	 * @param e
	 *            akadályozandó ellenség
	 * @return true, ha még él az akadály, false, ha nem
	 */
	@Override
	public boolean akadalyoz(IEllenseg e) {
		e.megall(2);
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
	 * 
	 * @return "Pók"
	 */
	@Override
	public String toString() {
		return "Pók";
	}

	@Override
	public Color getSzin() {
		return new Color(64, 64, 64);
	}

	@Override
	public int getKoltseg() {
		return KOLTSEG;
	}
}
