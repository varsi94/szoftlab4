package Varazsko;

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
	 * Költség lekérdezése
	 * @return költség
	 */
	@Override
	public int getKoltseg() {
		return koltseg;
	}

	/**
	 * Hatás kifejtése
	 * @param t Céltorony
	 * @return Sikerült-e
	 */
	@Override
	public boolean hat(ITorony t) {
		t.setSebzes(ITorony.SEBZODES_TORP_INDEX);
		return true;
	}

	/**
	 * Konstruktor
	 */
	public FeketeVarazsko() {
		koltseg = 50;
	}
}
