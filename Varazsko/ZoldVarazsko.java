package Varazsko;

import Szkeleton.Main;
import Torony.ITorony;

/**
 * Var�zsk�, mely a torony sebz�s�t megn�veli a hobbitokkal szemben. Csak toronyra lehet r�helyezni.
 * 
 * @author Varsi
 */
public class ZoldVarazsko implements ITVarazsko {
	/**
	 * Azt t�rolja, hogy mennyibe ker�l a var�zsk� haszn�lata.
	 */
	private int koltseg;

	/**
	 * Visszaadja hogy mennyi var�zser�be ker�l lerakni egy var�zsk�vet.
	 * 
	 * @return a k�lts�g
	 */
	@Override
	public int getKoltseg() {
		return koltseg;
	}

	/**
	 * A f�ggv�ny megvizsg�lja, hogy hathat-e a toronyra. Ha igen, kifejti hat�s�t
	 * 
	 * @param t
	 *            a c�ltorony
	 * @return siker�lt-e a hat�st el�rni
	 */
	@Override
	public boolean hat(ITorony t) {
		Main.log();
		t.getSebzes(1);
		t.setSebzes(1);
		return true;
	}

	/**
	 * Konstruktor
	 */
	public ZoldVarazsko() {
		Main.log();
		koltseg = 0;
	}
}
