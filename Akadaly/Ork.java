package Akadaly;

import Cella.Cella;
import Ellenseg.IEllenseg;
import Prototipus.Kimenet;

/**
 * Orkot reprezent�l� oszt�ly
 */
public class Ork extends AAkadaly {
	private static final long serialVersionUID = -8789176812576475815L;
	
	/**
	 * Ork k�lts�ge.
	 */
	private static final int ORK_KOLTSEG = 120;
	
	/**
	 * Ork h�ny ellens�get tud meg�lni.
	 */
	private static final int ORK_HATAS = 1;

	/**
	 * Ork konstruktor
	 * @param c A cella, amin az ork �ll.
	 */
	public Ork(Cella c) {
		super(ORK_KOLTSEG, ORK_HATAS, c);
	}

	/**
	 * Akad�lyoz� met�dus.
	 * @param e Az akad�lyozand� ellens�g
	 * @return True, ha m�g �l, False, ha nem.
	 */
	@Override
	public boolean akadalyoz(IEllenseg e) {
		Kimenet.akadalyAktivalodik(this);
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
	 * Ki�r�t�shoz
	 * @return "Ork"
	 */
	@Override
	public String toString() {
		return "Ork";
	}
}
