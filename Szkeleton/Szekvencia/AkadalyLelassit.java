/**
 * 
 */
package Szkeleton.Szekvencia;

import Palya.Palya;


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
		Palya p = new Palya();
		p.motor();
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
