/**
 * 
 */
package Szkeleton.Szekvencia;
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
		Palya p = new Palya();
		p.motor();
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
