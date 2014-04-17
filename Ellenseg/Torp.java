package Ellenseg;

import Palya.Palya;
import Torony.ITorony;

public class Torp extends Kaszt {

	private static final int TORP_START_HP = 20;
	private static final int TORP_START_SPEED = 5;

	/**
	 * Konstruktor az út elejérõl való induláshoz
	 * 
	 * @param palya
	 *            a pálya
	 * @param utIndex
	 *            az út indexe
	 */
	public Torp(Palya palya, int utIndex) {
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
	public Torp(Palya palya, int utIndex, int cellaIndex) {
		super(palya, TORP_START_SPEED, TORP_START_HP, utIndex, cellaIndex);
	}

	@Override
	protected int getSebzodes(ITorony t) {
		return t.getSebzes(ITorony.SEBZODES_TORP_INDEX);
	}

	@Override
	public char getMarkChar() {
		// Dwarf
		return 'd';
	}

}
