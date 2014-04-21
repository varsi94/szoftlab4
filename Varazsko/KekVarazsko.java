package Varazsko;

import Torony.ITorony;

/**
 * Varázskõ, amely a torony tüzelési gyakoriságát növeli.
 * 
 * @author Varsi
 * 
 */
public class KekVarazsko implements ITVarazsko {

	/**
	 * Azt tárolja, hogy mennyi varázserõbe kerül a használata.
	 */
	private int koltseg;

	/**
	 * Költség lekérdezése
	 * @return a költség
	 */
	@Override
	public int getKoltseg() {
		return koltseg;
	}

	/**
	 * Hatás kifejtése
	 * @param t A Céltorony
	 * @return Sikerült-e
	 */
	@Override
	public boolean hat(ITorony t) {
		return t.setTuzgyak();
	}

	/**
	 * Konstruktor
	 */
	public KekVarazsko() {
		koltseg = 0;
	}

}
