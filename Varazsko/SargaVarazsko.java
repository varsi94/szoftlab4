package Varazsko;

import Torony.ITorony;

/**
 * Varázskõ, mely a torony sebzését megnöveli az emberekkel szemben. Csak toronyra lehet ráhelyezni.
 * 
 * @author Varsi
 * 
 */
public class SargaVarazsko implements ITVarazsko {
	public static final int KOLTSEG = 50;

	/**
	 * Hatás kifejtése
	 * 
	 * @param t
	 *            céltorony
	 * @return sikerült-e
	 */
	@Override
	public boolean hat(ITorony t) {
		t.setSebzes(ITorony.SEBZODES_EMBER_INDEX);
		return true;
	}
}
