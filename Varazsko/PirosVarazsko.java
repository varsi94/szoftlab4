package Varazsko;

import Torony.ITorony;

/**
 * Varázskõ, mely egy torony hatótávolságát növeli.Csak toronyra lehet ráhelyezni.
 * 
 * @author Varsi
 * 
 */
public class PirosVarazsko implements ITVarazsko {
	public static final int KOLTSEG = 220;

	/**
	 * /** Hatás kifejtése
	 * 
	 * @param t
	 *            a céltorony
	 * @return Sikerült-e
	 */
	@Override
	public boolean hat(ITorony t) {
		t.setHatotav();
		return true;
	}

}
