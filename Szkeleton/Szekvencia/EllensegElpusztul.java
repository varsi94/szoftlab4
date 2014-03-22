package Szkeleton.Szekvencia;
import Torony.ITorony;
import Torony.Torony;

/**
 * 
 */

/**
 * Osztály az "ellenség elpusztul" szekvencia reprezentálására.
 * @author Varsi
 *
 */
public class EllensegElpusztul implements ISzekvencia {

	/**
	 * A szekvencia elindítása
	 */
	public void indit() {
		ITorony torony = new Torony();
		torony.loves();
		
	}

	/**
	 * Név visszaadása
	 * @return Ellenség elpusztul
	 */
	@Override
	public String getName() {
		return "Ellenség elpusztul";
	}

}
