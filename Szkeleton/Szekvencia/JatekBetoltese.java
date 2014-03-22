/**
 * 
 */
package Szkeleton.Szekvencia;

import Palya.Palya;

/**
 * Oszt�ly a "j�t�k bet�l�se" szekvenci�ra.
 * @author Hanicz
 *
 */
public class JatekBetoltese implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
	 */
	@Override
	public void indit() {
		Palya p = new Palya();
		
		System.out.println("ObjectInputStream.readObject(p);");
	}

	/**
	 * Ez a met�dus adja vissza a szekvencia nev�t.
	 * @return J�t�k bet�lt�se
	 */
	@Override
	public String getName() {
		return "J�t�k bet�lt�se";
	}

}
