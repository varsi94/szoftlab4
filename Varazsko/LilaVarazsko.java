package Varazsko;

import Akadaly.IAkadaly;

/**
 * Varázskõ, mely egy akadályt fejleszt, annak megfelelõen, hogy mi a feladata.Csak akadályra lehet ráhelyezni.
 * 
 * @author Varsi
 * 
 */
public class LilaVarazsko implements IAVarazsko {
	/**
	 * Azt tárolja hogy mennyi varázserõbe kerül a használata
	 */
	private int koltseg;

	@Override
	public int getKoltseg() {
		return koltseg;
	}

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
