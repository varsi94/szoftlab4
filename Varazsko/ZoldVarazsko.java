package Varazsko;

import Szkeleton.Main;
import Torony.ITorony;

/**
 * Varázskõ, mely a torony sebzését megnöveli a hobbitokkal szemben. Csak
 * toronyra lehet ráhelyezni.
 * 
 * @author Varsi
 */
public class ZoldVarazsko implements ITVarazsko {
	/**
	 * Azt tárolja, hogy mennyibe kerül a varázskõ használata.
	 */
	private int koltseg;

	/**
	 * Visszaadja hogy mennyi varázserõbe kerül lerakni egy varázskövet.
	 * 
	 * @return a költség
	 */
	public int getKoltseg() {
		return koltseg;
	}

	/**
	 * A függvény megvizsgálja, hogy hathat-e a toronyra. Ha igen, kifejti
	 * hatását
	 * 
	 * @param t
	 *            a céltorony
	 * @return sikerült-e a hatást elérni
	 */
	public boolean hat(ITorony t) {
		Main.log();
		return true;
	}

	/**
	 * Konstruktor
	 */
	public ZoldVarazsko() {
		Main.log();
		koltseg = 0;
	}
}
