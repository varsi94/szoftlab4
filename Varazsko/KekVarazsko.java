package Varazsko;

import Torony.ITorony;

/**
 * Varázskõ, amely a torony tüzelési gyakoriságát növeli.
 * 
 * @author Varsi
 * 
 */
public class KekVarazsko implements ITVarazsko {
	public static final int KOLTSEG = 150;

	/**
	 * Hatás kifejtése
	 * 
	 * @param t
	 *            A Céltorony
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
	}

}
