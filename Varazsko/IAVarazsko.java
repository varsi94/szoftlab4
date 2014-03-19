package Varazsko;

import Akadaly.IAkadaly;

/**
 * Az interfész felelõssége hogy egységet alkosson a varázskövek között, hogy
 * lehessen rajta keresztül egy bármilyen típusúra hivatkozni ami akadályra hat.
 * 
 * @author Varsi
 * 
 */
public interface IAVarazsko {
	/**
	 * Visszaadja hogy hány varázserõbe kerül az adott kõ használata
	 * @return
	 */
	public int getKoltseg();
	/**
	 * A függvény megvizsgálja hogy hathat-e akadályra. Ha igen kifejti hatását.
	 * @param a célakadaly
	 * @return sikerült-e a mûvelet
	 */
	public boolean hat(IAkadaly a);
}
