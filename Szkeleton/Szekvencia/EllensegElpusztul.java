package Szkeleton.Szekvencia;
import Palya.Palya;

/**
 * 
 */

/**
 * Oszt�ly az "ellens�g elpusztul" szekvencia reprezent�l�s�ra.
 * @author Varsi
 *
 */
public class EllensegElpusztul implements ISzekvencia {

	/**
	 * A szekvencia elind�t�sa
	 */
	public void indit() {
		Palya p = new Palya();
		p.motor();
	}

	/**
	 * N�v visszaad�sa
	 * @return Ellens�g elpusztul
	 */
	@Override
	public String getName() {
		return "Ellens�g elpusztul";
	}

}
