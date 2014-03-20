package Varazsko;

import Szkeleton.Main;
import Torony.ITorony;

/**
 * Varázskõ, mely a torony sebzését megnöveli a tündékkel szemben. Csak toronyra lehet ráhelyezni.
 * 
 * @author Varsi
 * 
 */
public class FeherVarazsko implements ITVarazsko {

	/**
	 * Azt tárolja, hogy mennyi varázserõbe kerül a használata.
	 */
	private int koltseg;

	/**
	 * Visszaadja, hogy mennyibe kerül lerakni a varázskövet.
	 * 
	 * @return a költség
	 */
	@Override
	public int getKoltseg() {
		Main.log();
		return koltseg;
	}

	/**
	 * A függvény megvizsgálja hogy hathat-e toronyra. Ha igen kifejti hatását.
	 * 
	 * @param t
	 *            a céltorony
	 * @return sikerült-e elérni a hatást
	 */
	@Override
	public boolean hat(ITorony t) {
		Main.log();
		return true;
	}

	/**
	 * Konstruktor
	 */
	public FeherVarazsko() {
		Main.log();
		koltseg = 0;
	}

}
