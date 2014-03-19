package Varazsko;

import Szkeleton.Main;
import Torony.ITorony;

/**
 * Fekete varázskõ a torony fejlesztésére. Megnöveli a torony sebzését a
 * törpökkel szemben.
 * 
 * @author Varsi
 * 
 */
public class FeketeVarazsko implements ITVarazsko {

	/**
	 * Megmutatja, hogy mennyi varázserõ szükséges a létrehozáshoz.
	 */
	private int koltseg;

	/**
	 * Visszaadja, hogy mennyi varázserõbe kerül lerakni egy varázskövet.
	 * 
	 * @return költség
	 */
	public int getKoltseg() {
		Main.log();
		return koltseg;
	}

	/**
	 * A függvény megvizsgálja, hogy hathat-e a toronyra. Ha igen, kifejti
	 * hatását.
	 * 
	 * @param t
	 *            a céltorony
	 * @return sikerült-e a mûvelet
	 */
	public boolean hat(ITorony t) {
		Main.log();
		return true;
	}

	/**
	 * Konstruktor
	 */
	public FeketeVarazsko() {
		Main.log();
		koltseg = 0;
	}
}
