package Varazsko;

import Torony.ITorony;

/**
 * Var�zsk�, mely egy torony hat�t�vols�g�t n�veli.Csak toronyra lehet r�helyezni.
 * 
 * @author Varsi
 * 
 */
public class PirosVarazsko implements ITVarazsko {

	/**
	 * Azt t�rolja hogy mennyi var�zser�be ker�l a haszn�lata
	 */
	private int koltseg;

	@Override
	public int getKoltseg() {
		return koltseg;
	}

	@Override
	public boolean hat(ITorony t) {
		t.setHatotav();
		return true;
	}

	/**
	 * Konstruktor
	 */
	public PirosVarazsko() {
		koltseg = 0;
	}

}
