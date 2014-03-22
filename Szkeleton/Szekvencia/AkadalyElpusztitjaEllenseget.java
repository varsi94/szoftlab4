package Szkeleton.Szekvencia;

import Palya.Palya;

/**
 * Oszt�ly az "akad�ly elpuszt�tja az ellens�get" szekvencia reprezent�l�s�ra.
 * @author Varsi
 *
 */
public class AkadalyElpusztitjaEllenseget implements ISzekvencia {
	
	/**
	 * Ez a met�dus ind�tja el a szekvenci�t
	 */
	public void indit() {
		Palya p = new Palya();
		p.motor();
	}
	
	/**
	 * A szekvencia nev�t adja vissza
	 * @return
	 */
	public String getName() {
		return "Akad�ly elpuszt�tja az ellens�get";
	}

}
