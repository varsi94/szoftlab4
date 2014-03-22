/**
 * 
 */
package Szkeleton.Szekvencia;

import Palya.Palya;

/**
 * Osztály a "játék betölése" szekvenciára.
 * @author Hanicz
 *
 */
public class JatekBetoltese implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
	 */
	@Override
	public void indit() {
		Palya p = new Palya();
		
		System.out.println("ObjectInputStream.readObject(p);");
	}

	/**
	 * Ez a metódus adja vissza a szekvencia nevét.
	 * @return Játék betöltése
	 */
	@Override
	public String getName() {
		return "Játék betöltése";
	}

}
