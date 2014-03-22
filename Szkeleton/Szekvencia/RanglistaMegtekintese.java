/**
 * 
 */
package Szkeleton.Szekvencia;

import Ranglista.Ranglista;

/**
 * Osztály a "ranglista megtekintese" szekvenciára.
 * @author Hanicz
 *
 */
public class RanglistaMegtekintese implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
	 */
	@Override
	public void indit() {
		Ranglista r = new Ranglista();
		r.kiir();
	}

	/**
	 * Ez a metódus adja vissza a szekvencia nevét.
	 * @return Ranglista megtekintése
	 */
	@Override
	public String getName() {
		return "Ranglista megtekintése";
	}

}
