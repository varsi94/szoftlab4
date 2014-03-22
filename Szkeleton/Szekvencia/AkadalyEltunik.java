/**
 * 
 */
package Szkeleton.Szekvencia;

import Akadaly.IAkadaly;
import Akadaly.Ork;
import Cella.Cella;
import Ellenseg.Ember;
import Ellenseg.IEllenseg;

/**
 * Osztály az "akadály eltûnik" szekvencia reprezentálására.
 * Nincs teljesen kész!
 * @author Varsi
 *
 */
public class AkadalyEltunik implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
	 */
	@Override
	public void indit() {
		IAkadaly ork = new Ork(0, 0);
		IEllenseg ember = new Ember();
		ork.akadalyoz(ember);
	}

	/**
	 * Ez a metódus adja vissza a nevét a szekvenciának
	 * @return Akadály eltûnik
	 */
	@Override
	public String getName() {
		return "Akadály eltûnik";
	}

}
