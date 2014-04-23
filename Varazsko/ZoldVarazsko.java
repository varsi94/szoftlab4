package Varazsko;

import Torony.ITorony;

/**
 * Varázskõ, mely a torony sebzését megnöveli a hobbitokkal szemben. Csak toronyra lehet ráhelyezni.
 * 
 * @author Varsi
 */
public class ZoldVarazsko implements ITVarazsko {
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
		t.setSebzes(ITorony.SEBZODES_HOBBIT_INDEX);
		return true;
	}

}
