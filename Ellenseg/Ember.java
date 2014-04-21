package Ellenseg;

import Palya.Palya;
import Torony.ITorony;

public class Ember extends Kaszt {
	private static final long serialVersionUID = 3355684723009919840L;
	private static final int EMBER_START_HP = 80;
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
	}

	@Override
	protected int getSebzodes(ITorony t) {
		return t.getSebzes(ITorony.SEBZODES_EMBER_INDEX);
	}

	@Override
	public char getMarkChar() {
		return 'e';
	}
	
	@Override
	public String toString() {
		return "Ember";
	}

}
