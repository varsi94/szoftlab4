package Varazsko;

import Torony.ITorony;

/**
 * Fekete varázskõ a torony fejlesztésére. Megnöveli a torony sebzését a törpökkel szemben.
 * 
 * @author Varsi
 * 
 */
public class FeketeVarazsko implements ITVarazsko {
	public static final int KOLTSEG = 50;

	/**
	 * Hatás kifejtése
	 * 
	 * @param t
	 *            Céltorony
	 * @return Sikerült-e
	 */
	@Override
	public boolean hat(ITorony t) {
		t.setSebzes(ITorony.SEBZODES_TORP_INDEX);
		return true;
	}
}
