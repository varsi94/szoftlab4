/**
 * 
 */
package Szkeleton.Szekvencia;

import Ellenseg.Ember;
import Ellenseg.IEllenseg;

/**
 * Osztály az "ellenség lelassítása" szekvencia ábrázolására.
 * @author Varsi
 *
 */
public class EllensegLelassitasa implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
	 */
	@Override
	public void indit() {
		IEllenseg ember = new Ember();
		ember.megall(5);
	}

	/**
	 * Metódus, ami visszaadja a szekvencia nevét.
	 * @return Ellenség lelassítása
	 */
	@Override
	public String getName() {
		return "Ellenség lelassítása";
	}

}
