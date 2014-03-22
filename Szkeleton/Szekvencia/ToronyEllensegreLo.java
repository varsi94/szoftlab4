/**
 * 
 */
package Szkeleton.Szekvencia;

import Palya.Palya;


/**
 * Oszt�ly a "torony ellens�gre l�" szekvenci�ra.
 * @author Hanicz
 *
 */
public class ToronyEllensegreLo implements ISzekvencia {

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
	 * @return Torony ellens�gre l�
	 */
	@Override
	public String getName() {
		return "Torony ellens�gre l�";
	}

}