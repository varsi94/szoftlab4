package Varazsko;

import Torony.ITorony;

/**
 * Fekete var�zsk� a torony fejleszt�s�re. Megn�veli a torony sebz�s�t a t�rp�kkel szemben.
 * 
 * @author Varsi
 * 
 */
public class FeketeVarazsko implements ITVarazsko {
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
		t.setSebzes(ITorony.SEBZODES_TORP_INDEX);
		return true;
	}
}
