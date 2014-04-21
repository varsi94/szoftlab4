package Akadaly;

import Cella.Cella;
import Ellenseg.IEllenseg;
import Prototipus.Kimenet;

/**
 * Pokot reprezent�l� oszt�ly
 */
public class Pok extends AAkadaly {
	private static final long serialVersionUID = -3619434867885153060L;
	
	/**
	 * P�k k�lts�ge
	 */
	private static final int POK_KOLTSEG = 10;
	
	/**
	 * P�k default hat�sa
	 */
	private static final int POK_HATAS = 1;

	/**
	 * Konstrukor
	 * @param c A cella, ahol a p�k �ll.
	 */
	public Pok(Cella c) {
		super(POK_KOLTSEG, POK_HATAS, c);
	}

	/**
	 * Akad�lyoz� met�dus
	 * @param e	akad�lyozand� ellens�g
	 * @return true, ha m�g �l az akad�ly, false, ha nem
	 */
	@Override
	public boolean akadalyoz(IEllenseg e) {
		/**
		 * Ha olyan ellens�get kaptunk, amelyik �ppen lass�tva van, vagy ebben a k�rben kezdene haladni,
		 * akkor nem akad�lyozzuk.
		 */
		if (e.getKimarad() != 1 || e.isLassitott())			
			return true;
		else {
			Kimenet.akadalyAktivalodik(this);
			e.megall(2);
			return --hatas > 0;
		}
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
	 * @return "P�k"
	 */
	@Override
	public String toString() {
		return "P�k";
	}
}
