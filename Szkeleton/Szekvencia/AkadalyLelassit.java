/**
 * 
 */
package Szkeleton.Szekvencia;

import Akadaly.IAkadaly;
import Akadaly.Pok;
import Ellenseg.Ember;
import Ellenseg.IEllenseg;


/**
 * Osztály az "akadály lelassítja az ellenséget" szekvenciára.
 * @author Varsi
 *
 */
public class AkadalyLelassit implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
	 */
	@Override
	public void indit() {
		IAkadaly pok = new Pok(0, 0);
		IEllenseg ember = new Ember();
		pok.akadalyoz(ember);
	}

	/**
	 * Ez a metódus adja vissza a szekvencia nevét.
	 * @return Akadály lelassítja az ellenséget
	 */
	@Override
	public String getName() {
		return "Akadály lelassítja az ellenséget";
	}

}
