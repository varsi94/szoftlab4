package Varazsko;

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

	@Override
	public int getKoltseg() {
		return koltseg;
	}

	@Override
	public boolean hat(ITorony t) {
		return t.setTuzgyak();
	}

	/**
	 * Konstruktor
	 */
	public KekVarazsko() {
		koltseg = 0;
	}

}
