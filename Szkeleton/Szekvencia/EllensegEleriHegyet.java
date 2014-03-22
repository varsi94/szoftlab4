/**
 * 
 */
package Szkeleton.Szekvencia;

import Cella.Cella;
import Ellenseg.Ember;
import Ellenseg.IEllenseg;
import Palya.Palya;

/**
 * Osztály az "ellenség eléri a hegyet" szekvencia ábrázolására. 
 * @author Varsi
 *
 */
public class EllensegEleriHegyet implements ISzekvencia {

	/**
	 * A szekvencia indítására szolgáló metódus.
	 */
	public void indit() {
		IEllenseg ember = new Ember();
		Cella ujCella = new Cella(0,0,true);
		Palya p = new Palya();
		ember.getUtIndex();
		ember.halad(ujCella);
		p.lost();
	}

	/**
	 * Metódus a szekvencia nevének lekérdezésére.
	 * @return Ellenség eléri a hegyet.
	 */
	@Override
	public String getName() {
		return "Ellenség eléri a hegyet";
	}

}
