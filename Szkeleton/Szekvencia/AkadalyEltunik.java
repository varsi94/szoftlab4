/**
 * 
 */
package Szkeleton.Szekvencia;

import Akadaly.IAkadaly;
import Akadaly.Ork;
import Cella.Cella;
import Ellenseg.Ember;
import Ellenseg.IEllenseg;

/**
 * Oszt�ly az "akad�ly elt�nik" szekvencia reprezent�l�s�ra.
 * Nincs teljesen k�sz!
 * @author Varsi
 *
 */
public class AkadalyEltunik implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
	 */
	@Override
	public void indit() {
		IAkadaly ork = new Ork(0, 0);
		IEllenseg ember = new Ember();
		ork.akadalyoz(ember);
	}

	/**
	 * Ez a met�dus adja vissza a nev�t a szekvenci�nak
	 * @return Akad�ly elt�nik
	 */
	@Override
	public String getName() {
		return "Akad�ly elt�nik";
	}

}
