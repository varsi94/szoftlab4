package Varazsko;

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

	@Override
	public int getKoltseg() {
		return koltseg;
	}

	@Override
	public boolean hat(ITorony t) {
		t.setSebzes(ITorony.SEBZODES_TUNDE_INDEX);
		return true;
	}

	/**
	 * Konstruktor
	 */
	public FeherVarazsko() {
	}

}
