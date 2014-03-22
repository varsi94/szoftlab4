package Szkeleton.Szekvencia;

import Akadaly.IAkadaly;
import Akadaly.Ork;
import Ellenseg.Ember;
import Ellenseg.IEllenseg;

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
		IAkadaly ork = new Ork(0,0);
		IEllenseg ember = new Ember();
		ork.akadalyoz(ember);
	}
	
	/**
	 * A szekvencia nev�t adja vissza
	 * @return
	 */
	public String getName() {
		return "Akad�ly elpuszt�tja az ellens�get";
	}

}
