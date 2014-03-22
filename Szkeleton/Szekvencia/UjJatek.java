/**
 * 
 */
package Szkeleton.Szekvencia;

import Palya.Palya;

/**
 * Oszt�ly az "�j j�t�k" szekvenci�ra.
 * @author Hanicz
 *
 */
public class UjJatek implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
	 */
	@Override
	public void indit() {
		Palya p = new Palya();
		
	}

	/**
	 * Ez a met�dus adja vissza a szekvencia nev�t.
	 * @return �j j�t�k
	 */
	@Override
	public String getName() {
		return "�j j�t�k";
	}

}
