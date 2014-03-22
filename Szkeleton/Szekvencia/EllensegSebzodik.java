/**
 * 
 */
package Szkeleton.Szekvencia;

import Ellenseg.Ember;
import Ellenseg.IEllenseg;
import Torony.ITorony;
import Torony.Torony;

/**
 * Oszt�ly az "ellens�g sebz�dik" szekvencia kezel�s�re
 * @author Varsi
 *
 */
public class EllensegSebzodik implements ISzekvencia {

	/**
	 * Szekvencia ind�t�sa
	 */
	public void indit() {
		IEllenseg ember = new Ember();
		ITorony torony = new Torony();
		ember.sebzodik(torony);
	}

	/**
	 * Met�dus, amely visszaadja a szekvencia nev�t - ki�r�shoz sz�ks�ges
	 * @return a szekvencia neves
	 */
	public String getName() {
		return "Ellens�g sebz�dik";
	}

}
