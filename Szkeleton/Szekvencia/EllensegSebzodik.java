/**
 * 
 */
package Szkeleton.Szekvencia;

import Torony.Torony;

/**
 * Oszt�ly az "ellens�g sebz�dik" szekvencia kezel�s�re
 * @author Varsi
 *
 */
public class EllensegSebzodik implements ISzekvencia {

	/**
	 * 
	 */
	@Override
	public void indit() {
		Torony t = new Torony();
		t.loves();
	}

	/**
	 * @return
	 */
	@Override
	public String getName() {
		return "Ellens�g sebz�dik";
	}

}
