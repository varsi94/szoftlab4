package Szkeleton.Szekvencia;
import Torony.ITorony;
import Torony.Torony;

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
		ITorony torony = new Torony();
		torony.loves();
		
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
