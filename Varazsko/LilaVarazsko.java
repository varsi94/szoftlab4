package Varazsko;

import Akadaly.IAkadaly;

/**
 * Var�zsk�, mely egy akad�lyt fejleszt, annak megfelel�en, hogy mi a feladata.Csak akad�lyra lehet r�helyezni.
 * 
 * @author Varsi
 * 
 */
public class LilaVarazsko implements IAVarazsko {
	public static final int KOLTSEG = 80;

	/**
	 * Hat�s kifejt�se
	 * 
	 * @param a
	 *            c�lakad�ly
	 * @return siker�lt-e
	 */
	@Override
	public boolean hat(IAkadaly a) {
		a.fejleszt();
		return true;
	}

	/**
	 * Konstruktor
	 */
	public LilaVarazsko() {
	}
}
