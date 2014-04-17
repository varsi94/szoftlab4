/**
 * 
 */
package Szkeleton.Szekvencia;

import Palya.Palya;

/**
 * Oszt�ly az "akad�ly elt�nik" szekvencia reprezent�l�s�ra.
 * @author Varsi
 *
 */
public class AkadalyEltunik implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
	 */
	public void indit() {
		Palya p = new Palya();
		p.motor();
	}

	/**
	 * Ez a met�dus adja vissza a nev�t a szekvenci�nak
	 * @return Akad�ly elt�nik
	 */
	@Override
	public String getName() {
		return "Akad�ly elt�nik";
	}

}
