/**
 * 
 */
package Szkeleton.Szekvencia;

import Palya.Palya;

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
		Palya p = new Palya();
		p.motor();
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
