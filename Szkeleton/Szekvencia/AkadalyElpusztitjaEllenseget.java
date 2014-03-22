package Szkeleton.Szekvencia;

import Akadaly.IAkadaly;
import Akadaly.Ork;
import Ellenseg.Ember;
import Ellenseg.IEllenseg;

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
		IAkadaly ork = new Ork(0,0);
		IEllenseg ember = new Ember();
		ork.akadalyoz(ember);
	}
	
	/**
	 * A szekvencia nevét adja vissza
	 * @return
	 */
	public String getName() {
		return "Akadály elpusztítja az ellenséget";
	}

}
