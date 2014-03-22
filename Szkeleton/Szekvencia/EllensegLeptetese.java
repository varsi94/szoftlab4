/**
 * 
 */
package Szkeleton.Szekvencia;

import Cella.Cella;
import Ellenseg.Ember;
import Ellenseg.IEllenseg;

/**
 * Osztály az "ellenség léptetése" szekvencia ábrázolására.
 * 
 * @author Varsi
 * 
 */
public class EllensegLeptetese implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
	 */
	public void indit() {
		IEllenseg ember = new Ember();
		ember.getCellaIndex();
		Cella ujCella = new Cella(0, 0, true);
		ember.halad(ujCella);
	}

	/**
	 * Metódus, ami visszaadja a szekvencia nevét.
	 * @return Ellenség léptetése.
	 */
	@Override
	public String getName() {
		return "Ellenség léptetése";
	}

}
