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

	@Override
	public int getKoltseg() {
		return koltseg;
	}

	@Override
	public boolean hat(ITorony t) {
		t.setSebzes(ITorony.SEBZODES_TORP_INDEX);
		return true;
	}

	/**
	 * Konstruktor
	 */
	public FeketeVarazsko() {
		koltseg = 0;
	}
}
