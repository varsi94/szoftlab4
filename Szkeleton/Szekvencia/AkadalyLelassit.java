/**
 * 
 */
package Szkeleton.Szekvencia;

import Palya.Palya;


/**
 * Oszt�ly az "akad�ly lelass�tja az ellens�get" szekvenci�ra.
 * @author Varsi
 *
 */
public class AkadalyLelassit implements ISzekvencia {

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
	 * @return Akad�ly lelass�tja az ellens�get
	 */
	@Override
	public String getName() {
		return "Akad�ly lelass�tja az ellens�get";
	}

}
