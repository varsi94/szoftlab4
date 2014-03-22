package Szkeleton.Szekvencia;

import Palya.Palya;

/**
 * Osztály a ranglistába írás szekvencia megvalósítására.
 * @author Varsi
 *
 */
public class RanglistabaIras implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
	 */
	public void indit() {
		Palya p = new Palya();
		p.motor();
	}

	/**
	 * Ez a metódus adja vissza a szekvencia nevét.
	 * @return Ranglistába írása
	 */
	@Override
	public String getName() {
		return "Ranglistába írás";
	}

}
