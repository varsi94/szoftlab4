/**
 * 
 */
package Szkeleton.Szekvencia;

import Palya.Palya;


/**
 * Oszt�ly az "uj kor" szekvenci�ra.
 * @author Hanicz
 *
 */
public class UjKor implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
	 */
	@Override
	public void indit() {
		Palya p = new Palya();
		
		p.motor();
	}

	/**
	 * Ez a met�dus adja vissza a szekvencia nev�t.
	 * @return �j k�r
	 */
	@Override
	public String getName() {
		return "�j k�r";
	}

}