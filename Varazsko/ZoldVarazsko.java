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

	/**
	 * K�lts�g lek�rdez�se
	 * @return k�lts�g
	 */
	@Override
	public int getKoltseg() {
		return koltseg;
	}

	/**
	 * Hat�s kifejt�se
	 * @param t c�ltorony
	 * @return siker�lt-e
	 */
	@Override
	public boolean hat(ITorony t) {
		t.setSebzes(ITorony.SEBZODES_HOBBIT_INDEX);
		return true;
	}

	/**
	 * Konstruktor
	 */
	public ZoldVarazsko() {
		koltseg = 50;
	}
}
