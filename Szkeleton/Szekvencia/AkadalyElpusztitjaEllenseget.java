package Szkeleton.Szekvencia;

import Palya.Palya;

/**
 * Osztály az "akadály elpusztítja az ellenséget" szekvencia reprezentálására.
 * @author Varsi
 *
 */
public class AkadalyElpusztitjaEllenseget implements ISzekvencia {
	
	/**
	 * Ez a metódus indítja el a szekvenciát
	 */
	public void indit() {
		Palya p = new Palya();
		p.motor();
	}
	
	/**
	 * A szekvencia nevét adja vissza
	 * @return
	 */
	public String getName() {
		return "Akadály elpusztítja az ellenséget";
	}

}
