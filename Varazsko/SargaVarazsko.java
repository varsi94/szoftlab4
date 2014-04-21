package Varazsko;

import Torony.ITorony;

/**
 * Varázskõ, mely a torony sebzését megnöveli az emberekkel szemben. Csak toronyra lehet ráhelyezni.
 * 
 * @author Varsi
 * 
 */
public class SargaVarazsko implements ITVarazsko {

	/**
	 * Azt tárolja hogy mennyi varázserõbe kerül a használata
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
		t.setSebzes(ITorony.SEBZODES_EMBER_INDEX);
		return true;
	}

	/**
	 * Konstruktor
	 */
	public SargaVarazsko() {
		koltseg = 0;
	}
}
