package Varazsko;

import Torony.ITorony;

/**
 * Var�zsk�, mely a torony sebz�s�t megn�veli a hobbitokkal szemben. Csak toronyra lehet r�helyezni.
 * 
 * @author Varsi
 */
public class ZoldVarazsko implements ITVarazsko {
	public static final int KOLTSEG = 50;

	/**
	 * Hat�s kifejt�se
	 * 
	 * @param t
	 *            c�ltorony
	 * @return siker�lt-e
	 */
	@Override
	public boolean hat(ITorony t) {
		t.setSebzes(ITorony.SEBZODES_HOBBIT_INDEX);
		return true;
	}

}
