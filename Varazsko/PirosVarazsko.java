package Varazsko;

import Torony.ITorony;

/**
 * Varázskõ, mely egy torony hatótávolságát növeli.Csak toronyra lehet ráhelyezni.
 * 
 * @author Varsi
 * 
 */
public class PirosVarazsko implements ITVarazsko {

	/**
	 * Azt tárolja hogy mennyi varázserõbe kerül a használata
	 */
	private int koltseg;

	/**
	 * Költség lekérdezése
	 * @return költség
	 */
	@Override
	public int getKoltseg() {
		return koltseg;
	}

	/**
	 * Hatás kifejtése
	 * @param t a céltorony
	 * @return Sikerült-e
	 */
	@Override
	public boolean hat(ITorony t) {
		t.setHatotav();
		return true;
	}

	/**
	 * Konstruktor
	 */
	public PirosVarazsko() {
		koltseg = 0;
	}

}
