package Varazsko;

import Szkeleton.Main;
import Torony.ITorony;

/**
 * Varázskõ, mely a torony sebzését megnöveli az emberekkel szemben. Csak
 * toronyra lehet ráhelyezni.
 * 
 * @author Varsi
 * 
 */
public class SargaVarazsko implements ITVarazsko {

	/**
	 * Azt tárolja hogy mennyi varázserõbe kerül a használata
	 */
	private int koltseg;

	/**
	 * Visszaadja hogy mennyibe kerül lerakni egy varázskövet
	 * 
	 * @return a költség
	 */
	public int getKoltseg() {
		Main.log();
		return koltseg;
	}

	/**
	 * A függvény megvizsgálja hogy hathat-e toronyra. Ha igen kifejti hatását.
	 * 
	 * @param t
	 *            a céltorony
	 * @return sikerült-e a mûvelet
	 */
	public boolean hat(ITorony t) {
		Main.log();
		return true;
	}

	/**
	 * Konstruktor
	 */
	public SargaVarazsko() {
		Main.log();
		koltseg = 0;
	}
}
