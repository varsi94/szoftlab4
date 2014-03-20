package Varazsko;

import Akadaly.IAkadaly;
import Szkeleton.Main;

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

	/**
	 * Visszaadja hogy mennyibe kerül lerakni egy varázskövet
	 * 
	 * @return a költség
	 */
	@Override
	public int getKoltseg() {
		Main.log();
		return koltseg;
	}

	/**
	 * A függvény megvizsgálja hogy hathat-e akadályra. Ha igen kifejti hatását.
	 * 
	 * @param a
	 *            célakadály
	 * @return sikerült-e a mûvelet
	 */
	@Override
	public boolean hat(IAkadaly a) {
		Main.log();
		return true;
	}

	/**
	 * Konstruktor
	 */
	public LilaVarazsko() {
		Main.log();
		koltseg = 0;
	}
}
