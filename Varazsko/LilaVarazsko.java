package Varazsko;

import Akadaly.IAkadaly;
import Szkeleton.Main;

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

	/**
	 * Visszaadja hogy mennyibe ker�l lerakni egy var�zsk�vet
	 * 
	 * @return a k�lts�g
	 */
	@Override
	public int getKoltseg() {
		Main.log();
		return koltseg;
	}

	/**
	 * A f�ggv�ny megvizsg�lja hogy hathat-e akad�lyra. Ha igen kifejti hat�s�t.
	 * 
	 * @param a
	 *            c�lakad�ly
	 * @return siker�lt-e a m�velet
	 */
	@Override
	public boolean hat(IAkadaly a) {
		Main.log();
		return true;
	}

	/**
	 * Konstruktor
	 */
	public LilaVarazsko() {
		Main.log();
		koltseg = 0;
	}
}
