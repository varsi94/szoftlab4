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

	/**
	 * K�lts�g lek�rdez�se
	 * @return a k�lts�g
	 */
	@Override
	public int getKoltseg() {
		return koltseg;
	}

	/**
	 * Hat�s kifejt�se
	 * @param t A C�ltorony
	 * @return Siker�lt-e
	 */
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
