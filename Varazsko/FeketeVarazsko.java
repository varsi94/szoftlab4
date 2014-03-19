package Varazsko;

import Szkeleton.Main;
import Torony.ITorony;

/**
 * Fekete var�zsk� a torony fejleszt�s�re. Megn�veli a torony sebz�s�t a
 * t�rp�kkel szemben.
 * 
 * @author Varsi
 * 
 */
public class FeketeVarazsko implements ITVarazsko {

	/**
	 * Megmutatja, hogy mennyi var�zser� sz�ks�ges a l�trehoz�shoz.
	 */
	private int koltseg;

	/**
	 * Visszaadja, hogy mennyi var�zser�be ker�l lerakni egy var�zsk�vet.
	 * 
	 * @return k�lts�g
	 */
	public int getKoltseg() {
		Main.log();
		return koltseg;
	}

	/**
	 * A f�ggv�ny megvizsg�lja, hogy hathat-e a toronyra. Ha igen, kifejti
	 * hat�s�t.
	 * 
	 * @param t
	 *            a c�ltorony
	 * @return siker�lt-e a m�velet
	 */
	public boolean hat(ITorony t) {
		Main.log();
		return true;
	}

	/**
	 * Konstruktor
	 */
	public FeketeVarazsko() {
		Main.log();
		koltseg = 0;
	}
}
