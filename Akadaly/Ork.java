package Akadaly;

import java.awt.Color;

import Cella.Cella;
import Ellenseg.IEllenseg;

/**
 * Orkot reprezentáló osztály
 */
public class Ork extends AAkadaly {
	private static final long serialVersionUID = -8789176812576475815L;

	/**
	 * Ork költsége.
	 */
	public static final int KOLTSEG = 120;

	/**
	 * Ork hány ellenséget tud megölni.
	 */
	private static final int ORK_HATAS = 1;

	/**
	 * Ork konstruktor
	 * 
	 * @param c
	 *            A cella, amin az ork áll.
	 */
	public Ork(Cella c) {
		super(ORK_HATAS, c);
	}

	/**
	 * Akadályozó metódus.
	 * 
	 * @param e
	 *            Az akadályozandó ellenség
	 * @return True, ha még él, False, ha nem.
	 */
	@Override
	public boolean akadalyoz(IEllenseg e) {
		e.meghal();
		System.out.println("Ork.akadalyoz()");
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
	 * Kiírátáshoz
	 * 
	 * @return "Ork"
	 */
	@Override
	public String toString() {
		return "Ork";
	}

	@Override
	protected Color getAkadalyColor() {
		return new Color(139, 69, 19);
	}

	@Override
	public int getKoltseg() {
		return KOLTSEG;
	}

}
