/**
 * 
 */
package Szkeleton.Szekvencia;

import Ellenseg.Ember;
import Ellenseg.IEllenseg;

/**
 * Oszt�ly az "ellens�g lelass�t�sa" szekvencia �br�zol�s�ra.
 * @author Varsi
 *
 */
public class EllensegLelassitasa implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
	 */
	@Override
	public void indit() {
		IEllenseg ember = new Ember();
		ember.megall(5);
	}

	/**
	 * Met�dus, ami visszaadja a szekvencia nev�t.
	 * @return Ellens�g lelass�t�sa
	 */
	@Override
	public String getName() {
		return "Ellens�g lelass�t�sa";
	}

}
