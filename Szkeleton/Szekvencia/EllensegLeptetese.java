/**
 * 
 */
package Szkeleton.Szekvencia;

import Cella.Cella;
import Ellenseg.Ember;
import Ellenseg.IEllenseg;

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
		IEllenseg ember = new Ember();
		ember.getCellaIndex();
		Cella ujCella = new Cella(0, 0, true);
		ember.halad(ujCella);
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
