package Varazsko;

import Torony.ITorony;

/**
 * Varázskõ, mely a torony sebzését megnöveli a tündékkel szemben. Csak toronyra lehet ráhelyezni.
 * 
 * @author Varsi
 * 
 */
public class FeherVarazsko implements ITVarazsko {
	public static final int KOLTSEG = 50;

	/**
	 * Hatás kifejtése
	 * 
	 * @param t
	 *            Céltorony
	 * @return Sikerült-e
	 */
	@Override
	public boolean hat(ITorony t) {
		t.setSebzes(ITorony.SEBZODES_TUNDE_INDEX);
		return true;
	}

	/**
	 * Konstruktor
	 */
	public FeherVarazsko() {
	}

}
