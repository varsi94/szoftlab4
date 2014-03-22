/**
 * 
 */
package Szkeleton.Szekvencia;

import Akadaly.IAkadaly;
import Akadaly.Pok;
import Ellenseg.Ember;
import Ellenseg.IEllenseg;


/**
 * Oszt�ly az "akad�ly lelass�tja az ellens�get" szekvenci�ra.
 * @author Varsi
 *
 */
public class AkadalyLelassit implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
	 */
	@Override
	public void indit() {
		IAkadaly pok = new Pok(0, 0);
		IEllenseg ember = new Ember();
		pok.akadalyoz(ember);
	}

	/**
	 * Ez a met�dus adja vissza a szekvencia nev�t.
	 * @return Akad�ly lelass�tja az ellens�get
	 */
	@Override
	public String getName() {
		return "Akad�ly lelass�tja az ellens�get";
	}

}
