/**
 * 
 */
package Szkeleton.Szekvencia;

import Akadaly.IAkadaly;
import Akadaly.Ork;
import Ellenseg.Ember;
import Ellenseg.IEllenseg;
import Palya.Palya;

/**
 * Osztály az "akadály eltûnik" szekvencia reprezentálására.
 * @author Varsi
 *
 */
public class AkadalyEltunik implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
	 */
	public void indit() {
		Palya p = new Palya();
		p.motor();
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
