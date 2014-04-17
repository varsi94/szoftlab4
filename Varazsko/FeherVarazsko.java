package Varazsko;

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

	@Override
	public int getKoltseg() {
		return koltseg;
	}

	@Override
	public boolean hat(ITorony t) {
		t.setSebzes(ITorony.SEBZODES_TUNDE_INEDX);
		return true;
	}

	/**
	 * Konstruktor
	 */
	public FeherVarazsko() {
	}

}
