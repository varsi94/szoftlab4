package Varazsko;

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

	@Override
	public int getKoltseg() {
		return koltseg;
	}

	@Override
	public boolean hat(ITorony t) {
		t.setSebzes(ITorony.SEBZODES_TORP_INDEX);
		return true;
	}

	/**
	 * Konstruktor
	 */
	public FeketeVarazsko() {
		koltseg = 0;
	}
}
