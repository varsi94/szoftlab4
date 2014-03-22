/**
 * 
 */
package Szkeleton.Szekvencia;
import Palya.Palya;

/**
 * Oszt�ly az "ellens�g el�ri a hegyet" szekvencia �br�zol�s�ra. 
 * @author Varsi
 *
 */
public class EllensegEleriHegyet implements ISzekvencia {

	/**
	 * A szekvencia ind�t�s�ra szolg�l� met�dus.
	 */
	public void indit() {
		Palya p = new Palya();
		p.motor();
	}

	/**
	 * Met�dus a szekvencia nev�nek lek�rdez�s�re.
	 * @return Ellens�g el�ri a hegyet.
	 */
	@Override
	public String getName() {
		return "Ellens�g el�ri a hegyet";
	}

}
