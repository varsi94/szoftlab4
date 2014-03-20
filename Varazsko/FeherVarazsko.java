package Varazsko;

import Szkeleton.Main;
import Torony.ITorony;

/**
 * Var�zsk�, mely a torony sebz�s�t megn�veli a t�nd�kkel szemben. Csak toronyra lehet r�helyezni.
 * 
 * @author Varsi
 * 
 */
public class FeherVarazsko implements ITVarazsko {

	/**
	 * Azt t�rolja, hogy mennyi var�zser�be ker�l a haszn�lata.
	 */
	private int koltseg;

	/**
	 * Visszaadja, hogy mennyibe ker�l lerakni a var�zsk�vet.
	 * 
	 * @return a k�lts�g
	 */
	@Override
	public int getKoltseg() {
		Main.log();
		return koltseg;
	}

	/**
	 * A f�ggv�ny megvizsg�lja hogy hathat-e toronyra. Ha igen kifejti hat�s�t.
	 * 
	 * @param t
	 *            a c�ltorony
	 * @return siker�lt-e el�rni a hat�st
	 */
	@Override
	public boolean hat(ITorony t) {
		Main.log();
		return true;
	}

	/**
	 * Konstruktor
	 */
	public FeherVarazsko() {
		Main.log();
		koltseg = 0;
	}

}
