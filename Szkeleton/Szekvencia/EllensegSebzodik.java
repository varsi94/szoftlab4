/**
 * 
 */
package Szkeleton.Szekvencia;

import Ellenseg.Ember;
import Ellenseg.IEllenseg;
import Torony.ITorony;
import Torony.Torony;

/**
 * Osztály az "ellenség sebzõdik" szekvencia kezelésére
 * @author Varsi
 *
 */
public class EllensegSebzodik implements ISzekvencia {

	/**
	 * Szekvencia indítása
	 */
	public void indit() {
		IEllenseg ember = new Ember();
		ITorony torony = new Torony();
		ember.sebzodik(torony);
	}

	/**
	 * Metódus, amely visszaadja a szekvencia nevét - kiíráshoz szükséges
	 * @return a szekvencia neves
	 */
	public String getName() {
		return "Ellenség sebzõdik";
	}

}
