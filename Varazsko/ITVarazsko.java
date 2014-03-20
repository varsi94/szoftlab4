package Varazsko;

import Torony.ITorony;

/**
 * Toronyra ható varázskövek interfésze.
 * 
 * @author Varsi
 */
public interface ITVarazsko {
	/**
	 * Visszaadja hogy hány varázserõbe kerül az adott kõ használata.
	 * 
	 * @return költség
	 */
	public int getKoltseg();

	/**
	 * A függvény megvizsgálja hogy hathat-e toronyra. Ha igen kifejti hatását.
	 * 
	 * @param t
	 *            A céltorony
	 * @return sikerült-e a varázskõ használata
	 */
	public boolean hat(ITorony t);
}
