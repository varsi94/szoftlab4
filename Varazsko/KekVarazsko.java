package Varazsko;

import Szkeleton.Main;
import Torony.ITorony;

/**
 * Var�zsk�, amely a torony t�zel�si gyakoris�g�t n�veli.
 * 
 * @author Varsi
 * 
 */
public class KekVarazsko implements ITVarazsko {

	/**
	 * Azt t�rolja, hogy mennyi var�zser�be ker�l a haszn�lata.
	 */
	private int koltseg;

	/**
	 * @return mennyibe ker�l lerakni egy var�zsk�vet.
	 */
	public int getKoltseg() {
		Main.log();
		return koltseg;
	}

	/**
	 * Var�zsk� hat a toronyra.
	 * 
	 * @param t
	 *            a c�ltorony
	 * @return siker�lt-e a hat�st el�rni.
	 */
	public boolean hat(ITorony t) {
		Main.log();
		return true;
	}

	/**
	 * Konstruktor
	 */
	public KekVarazsko() {
		Main.log();
		koltseg = 0;
	}

}
