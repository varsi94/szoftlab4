/**
 * 
 */
package Szkeleton.Szekvencia;

import Cella.Cella;
import Ellenseg.Ember;
import Ellenseg.IEllenseg;
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
		IEllenseg ember = new Ember();
		Cella ujCella = new Cella(0,0,true);
		Palya p = new Palya();
		ember.getUtIndex();
		ember.halad(ujCella);
		p.lost();
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
