package Szkeleton.Szekvencia;
import Palya.Palya;

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
		Palya p = new Palya();
		p.motor();
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
