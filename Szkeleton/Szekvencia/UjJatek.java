/**
 * 
 */
package Szkeleton.Szekvencia;

import Palya.Palya;

/**
 * Osztály az "új játék" szekvenciára.
 * @author Hanicz
 *
 */
public class UjJatek implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
	 */
	@Override
	public void indit() {
		Palya p = new Palya();
		
	}

	/**
	 * Ez a metódus adja vissza a szekvencia nevét.
	 * @return Új játék
	 */
	@Override
	public String getName() {
		return "Új játék";
	}

}
