package Varazsko;

import Torony.ITorony;

/**
 * Varázskõ, mely a torony sebzését megnöveli a hobbitokkal szemben. Csak toronyra lehet ráhelyezni.
 * 
 * @author Varsi
 */
public class ZoldVarazsko implements ITVarazsko {
	/**
	 * Azt tárolja, hogy mennyibe kerül a varázskõ használata.
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
	 * @param t céltorony
	 * @return sikerült-e
	 */
	@Override
	public boolean hat(ITorony t) {
		t.setSebzes(ITorony.SEBZODES_HOBBIT_INDEX);
		return true;
	}

	/**
	 * Konstruktor
	 */
	public ZoldVarazsko() {
		koltseg = 50;
	}
}
