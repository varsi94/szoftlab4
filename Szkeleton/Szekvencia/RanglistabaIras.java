package Szkeleton.Szekvencia;

import Palya.Palya;

/**
 * Oszt�ly a ranglist�ba �r�s szekvencia megval�s�t�s�ra.
 * @author Varsi
 *
 */
public class RanglistabaIras implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
	 */
	public void indit() {
		Palya p = new Palya();
		p.motor();
	}

	/**
	 * Ez a met�dus adja vissza a szekvencia nev�t.
	 * @return Ranglist�ba �r�sa
	 */
	@Override
	public String getName() {
		return "Ranglist�ba �r�s";
	}

}
