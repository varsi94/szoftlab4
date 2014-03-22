/**
 * 
 */
package Szkeleton.Szekvencia;

import Palya.Palya;


/**
 * Osztály a "torony ellenségre lõ" szekvenciára.
 * @author Hanicz
 *
 */
public class ToronyEllensegreLo implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
	 */
	@Override
	public void indit() {
		Palya p = new Palya();
		
		p.motor();
		
	}

	/**
	 * Ez a metódus adja vissza a szekvencia nevét.
	 * @return Torony ellenségre lõ
	 */
	@Override
	public String getName() {
		return "Torony ellenségre lõ";
	}

}