package Ellenseg;

import Palya.Palya;
import Torony.ITorony;

/**
 * Embert reprezentáló osztály
 * @author Sipka
 *
 */
public class Ember extends Kaszt {

	private static final long serialVersionUID = 3355684723009919840L;

	/**
	 * Az ember megöléésért járó varázserõ
	 */
	private static final int EMBER_JUTALOM = 40;
	
	/**
	 * Ember kezdeti életpontja.
	 */
	private static final int EMBER_START_HP = 80;
	
	/**
	 * Ember sebessége: minden körben lép
	 */
	private static final int EMBER_START_SPEED = 1;

	/**
	 * Konstruktor az út elejérõl való induláshoz
	 * 
	 * @param palya
	 *            a pálya
	 * @param utIndex
	 *            az út indexe
	 */
	public Ember(Palya palya, int utIndex) {
		this(palya, utIndex, 0);
	}

	/**
	 * Konstruktor ellenség torony lövés duplikációhoz
	 * 
	 * @param palya
	 *            a pálya
	 * @param utIndex
	 *            az ut indexe
	 * @param cellaIndex
	 *            a cella indexe
	 */
	public Ember(Palya palya, int utIndex, int cellaIndex) {
		super(palya, EMBER_START_SPEED, EMBER_START_HP, utIndex, cellaIndex);
		jutalom = EMBER_JUTALOM;
	}
	
	/**
	 * Sebzõdés lekérése
	 * @param t A torony, ami lõ ránk.
	 * @return A sebzés mértéke
	 */
	@Override
	protected int getSebzodes(ITorony t) {
		return t.getSebzes(ITorony.SEBZODES_EMBER_INDEX);
	}

	/**
	 * Pálya kiíratásához a jelölõ.
	 * @return "e"
	 */
	@Override
	public char getMarkChar() {
		return 'e';
	}
	
	/**
	 * Kiíráshoz.
	 * @return "Ember"
	 */
	@Override
	public String toString() {
		return "Ember";
	}

}
