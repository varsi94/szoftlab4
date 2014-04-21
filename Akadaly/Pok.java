package Akadaly;

import Cella.Cella;
import Ellenseg.IEllenseg;
import Prototipus.Kimenet;

/**
 * Pokot reprezentáló osztály
 */
public class Pok extends AAkadaly {
	private static final long serialVersionUID = -3619434867885153060L;
	
	/**
	 * Pók költsége
	 */
	private static final int POK_KOLTSEG = 10;
	
	/**
	 * Pók default hatása
	 */
	private static final int POK_HATAS = 1;

	/**
	 * Konstrukor
	 * @param c A cella, ahol a pók áll.
	 */
	public Pok(Cella c) {
		super(POK_KOLTSEG, POK_HATAS, c);
	}

	/**
	 * Akadályozó metódus
	 * @param e	akadályozandó ellenség
	 * @return true, ha még él az akadály, false, ha nem
	 */
	@Override
	public boolean akadalyoz(IEllenseg e) {
		/**
		 * Ha olyan ellenséget kaptunk, amelyik éppen lassítva van, vagy ebben a körben kezdene haladni,
		 * akkor nem akadályozzuk.
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
	 * Fejlesztõ metódus.
	 */
	@Override
	public void fejleszt() {
		hatas++;
	}

	/**
	 * Kiíratáshoz
	 * @return "Pók"
	 */
	@Override
	public String toString() {
		return "Pók";
	}
}
