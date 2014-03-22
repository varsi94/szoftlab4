/**
 * 
 */
package Szkeleton.Szekvencia;

import Palya.Palya;

/**
 * Oszt�ly az "ellens�g l�ptet�se" szekvencia �br�zol�s�ra.
 * 
 * @author Varsi
 * 
 */
public class EllensegLeptetese implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
	 */
	public void indit() {
		Palya p = new Palya();
		p.motor();
	}

	/**
	 * Met�dus, ami visszaadja a szekvencia nev�t.
	 * @return Ellens�g l�ptet�se.
	 */
	@Override
	public String getName() {
		return "Ellens�g l�ptet�se";
	}

}
