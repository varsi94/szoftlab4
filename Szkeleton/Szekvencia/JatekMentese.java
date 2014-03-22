/**
 * 
 */
package Szkeleton.Szekvencia;

import Palya.Palya;


/**
 * Oszt�ly a "j�t�k ment�se" szekvenci�ra.
 * @author Hanicz
 *
 */
public class JatekMentese implements ISzekvencia {

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
	 * @return J�t�k Ment�se
	 */
	@Override
	public String getName() {
		return "J�t�k Ment�se";
	}

}