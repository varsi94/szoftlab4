/**
 * 
 */
package Szkeleton.Szekvencia;

import Palya.Palya;


/**
 * Osztály a "játék mentése" szekvenciára.
 * @author Hanicz
 *
 */
public class JatekMentese implements ISzekvencia {

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
	 * @return Játék Mentése
	 */
	@Override
	public String getName() {
		return "Játék Mentése";
	}

}