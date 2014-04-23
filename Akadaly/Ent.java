package Akadaly;

import java.awt.Color;

import Cella.Cella;
import Ellenseg.IEllenseg;

/**
 * Entet reprezent�l� oszt�ly
 */
public class Ent extends AAkadaly {
	private static final long serialVersionUID = 2061085673027741014L;

	/**
	 * Az ent k�lts�ge.
	 */
	public static final int KOLTSEG = 220;

	/**
	 * H�ny ellens�gre tud hatni az ent.
	 */
	private static final int ENT_HATAS = 3;

	/**
	 * Konstrukor
	 * 
	 * @param c
	 *            A cella, amin �ll az ent.
	 */
	public Ent(Cella c) {
		super(ENT_HATAS, c);
	}

	/**
	 * Akad�lyoz� met�dus
	 * 
	 * @param e
	 *            Az akad�lyozand� ellens�g.
	 * @return True, ha m�g �l, False, ha m�r nem
	 */
	@Override
	public boolean akadalyoz(IEllenseg e) {
		e.meghal();
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
	 * @return "Ent"
	 */
	@Override
	public String toString() {
		return "Ent";
	}

	@Override
	protected Color getAkadalyColor() {
		return new Color(0, 127, 0);
	}

	@Override
	public int getKoltseg() {
		return KOLTSEG;
	}

}
