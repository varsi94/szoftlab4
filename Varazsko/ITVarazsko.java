package Varazsko;

import Torony.ITorony;

/**
 * Toronyra ható varázskövek interfésze.
 * 
 * @author Varsi
 */
public interface ITVarazsko {

	/**
	 * A függvény megvizsgálja hogy hathat-e toronyra. Ha igen kifejti hatását.
	 * 
	 * @param t
	 *            A céltorony
	 * @return sikerült-e a varázskõ használata
	 */
	public boolean hat(ITorony t);
}
