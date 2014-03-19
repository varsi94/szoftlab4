package Varazsko;

import Szkeleton.Main;
import Torony.ITorony;

/**
 * Varázskõ, amely a torony tüzelési gyakoriságát növeli.
 * 
 * @author Varsi
 * 
 */
public class KekVarazsko implements ITVarazsko {

	/**
	 * Azt tárolja, hogy mennyi varázserõbe kerül a használata.
	 */
	private int koltseg;

	/**
	 * @return mennyibe kerül lerakni egy varázskövet.
	 */
	public int getKoltseg() {
		Main.log();
		return koltseg;
	}

	/**
	 * Varázskõ hat a toronyra.
	 * 
	 * @param t
	 *            a céltorony
	 * @return sikerült-e a hatást elérni.
	 */
	public boolean hat(ITorony t) {
		Main.log();
		return true;
	}

	/**
	 * Konstruktor
	 */
	public KekVarazsko() {
		Main.log();
		koltseg = 0;
	}

}
