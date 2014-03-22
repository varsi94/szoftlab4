/**
 * 
 */
package Szkeleton.Szekvencia;

import Ranglista.Ranglista;

/**
 * Oszt�ly a "ranglista megtekintese" szekvenci�ra.
 * @author Hanicz
 *
 */
public class RanglistaMegtekintese implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
	 */
	@Override
	public void indit() {
		Ranglista r = new Ranglista();
		r.kiir();
	}

	/**
	 * Ez a met�dus adja vissza a szekvencia nev�t.
	 * @return Ranglista megtekint�se
	 */
	@Override
	public String getName() {
		return "Ranglista megtekint�se";
	}

}
