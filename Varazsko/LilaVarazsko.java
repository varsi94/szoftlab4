package Varazsko;

import Akadaly.IAkadaly;

/**
 * Varázskõ, mely egy akadályt fejleszt, annak megfelelõen, hogy mi a feladata.Csak akadályra lehet ráhelyezni.
 * 
 * @author Varsi
 * 
 */
public class LilaVarazsko implements IAVarazsko {
	public static final int KOLTSEG = 80;

	/**
	 * Hatás kifejtése
	 * 
	 * @param a
	 *            célakadály
	 * @return sikerült-e
	 */
	@Override
	public boolean hat(IAkadaly a) {
		a.fejleszt();
		return true;
	}

	/**
	 * Konstruktor
	 */
	public LilaVarazsko() {
	}
}
