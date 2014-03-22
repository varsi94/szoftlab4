/**
 * 
 */
package Szkeleton.Szekvencia;

import Palya.Palya;

/**
 * Osztály a "játék vége" szekvencia ábrázolására.
 * @author Varsi
 *
 */
public class JatekVege implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
	 */
	public void indit() {
		Palya p = new Palya();
		p.lost();
	}

	/**
	 * Ez a metódus adja vissza a szekvencia nevét.
	 * @return Játék vége
	 */
	public String getName() {
		return "Játék vége";
	}

}
