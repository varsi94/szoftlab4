package Varazsko;

import Torony.ITorony;

/**
 * Var�zsk�, mely a torony sebz�s�t megn�veli az emberekkel szemben. Csak toronyra lehet r�helyezni.
 * 
 * @author Varsi
 * 
 */
public class SargaVarazsko implements ITVarazsko {
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
		t.setSebzes(ITorony.SEBZODES_EMBER_INDEX);
		return true;
	}
}
