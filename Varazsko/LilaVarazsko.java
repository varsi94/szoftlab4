package Varazsko;

import Akadaly.IAkadaly;

/**
 * Var�zsk�, mely egy akad�lyt fejleszt, annak megfelel�en, hogy mi a feladata.Csak akad�lyra lehet r�helyezni.
 * 
 * @author Varsi
 * 
 */
public class LilaVarazsko implements IAVarazsko {
	/**
	 * Azt t�rolja hogy mennyi var�zser�be ker�l a haszn�lata
	 */
	private int koltseg;

	@Override
	public int getKoltseg() {
		return koltseg;
	}

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
