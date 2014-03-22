/**
 * 
 */
package Szkeleton.Szekvencia;

import Torony.Torony;

/**
 * Osztály az "ellenség sebzõdik" szekvencia kezelésére
 * @author Varsi
 *
 */
public class EllensegSebzodik implements ISzekvencia {

	/**
	 * 
	 */
	@Override
	public void indit() {
		Torony t = new Torony();
		t.loves();
	}

	/**
	 * @return
	 */
	@Override
	public String getName() {
		return "Ellenség sebzõdik";
	}

}
