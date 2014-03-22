/**
 * 
 */
package Szkeleton.Szekvencia;

import Palya.Palya;


/**
 * Osztály az "uj kor" szekvenciára.
 * @author Hanicz
 *
 */
public class UjKor implements ISzekvencia {

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
	 * @return Új kör
	 */
	@Override
	public String getName() {
		return "Új kör";
	}

}