/**
 * 
 */
package Szkeleton.Szekvencia;

import Palya.Palya;

/**
 * Oszt�ly a "j�t�k v�ge" szekvencia �br�zol�s�ra.
 * @author Varsi
 *
 */
public class JatekVege implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
	 */
	public void indit() {
		Palya p = new Palya();
		p.lost();
	}

	/**
	 * Ez a met�dus adja vissza a szekvencia nev�t.
	 * @return J�t�k v�ge
	 */
	public String getName() {
		return "J�t�k v�ge";
	}

}
