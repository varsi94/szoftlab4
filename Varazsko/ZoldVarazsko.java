package Varazsko;

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

	@Override
	public int getKoltseg() {
		return koltseg;
	}

	@Override
	public boolean hat(ITorony t) {
		t.setSebzes(ITorony.SEBZODES_HOBBIT_INDEX);
		return true;
	}

	/**
	 * Konstruktor
	 */
	public ZoldVarazsko() {
	}
}
