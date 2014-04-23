package Varazsko;

import Torony.ITorony;

/**
 * Var�zsk�, mely a torony sebz�s�t megn�veli a t�nd�kkel szemben. Csak toronyra lehet r�helyezni.
 * 
 * @author Varsi
 * 
 */
public class FeherVarazsko implements ITVarazsko {
	public static final int KOLTSEG = 50;

	/**
	 * Hat�s kifejt�se
	 * 
	 * @param t
	 *            C�ltorony
	 * @return Siker�lt-e
	 */
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
