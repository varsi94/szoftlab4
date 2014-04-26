package Akadaly;

import java.awt.Color;

import Cella.Cella;
import Ellenseg.IEllenseg;

/**
 * Pokot reprezent�l� oszt�ly
 */
public class Pok extends AAkadaly {
	private static final long serialVersionUID = -3619434867885153060L;

	/**
	 * P�k k�lts�ge
	 */
	public static final int KOLTSEG = 50;

	/**
	 * P�k default hat�sa
	 */
	private static final int POK_HATAS = 1;

	/**
	 * Konstrukor
	 * 
	 * @param c
	 *            A cella, ahol a p�k �ll.
	 */
	public Pok(Cella c) {
		super(POK_HATAS, c);
	}

	/**
	 * Akad�lyoz� met�dus
	 * 
	 * @param e
	 *            akad�lyozand� ellens�g
	 * @return true, ha m�g �l az akad�ly, false, ha nem
	 */
	@Override
	public boolean akadalyoz(IEllenseg e) {
		e.megall(2);
		return --hatas > 0;
	}

	/**
	 * Fejleszt� met�dus.
	 */
	@Override
	public void fejleszt() {
		hatas++;
	}

	/**
	 * Ki�rat�shoz
	 * 
	 * @return "P�k"
	 */
	@Override
	public String toString() {
		return "P�k";
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
