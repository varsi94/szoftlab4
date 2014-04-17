package Ellenseg;

import Palya.Palya;
import Torony.ITorony;

public class Tunde extends Kaszt {

	private static final int TUNDE_START_HP = 8;
	private static final int TUNDE_START_SPEED = 2;

	/**
	 * Konstruktor az út elejérõl való induláshoz
	 * 
	 * @param palya
	 *            a pálya
	 * @param utIndex
	 *            az út indexe
	 */
	public Tunde(Palya palya, int utIndex) {
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
	public Tunde(Palya palya, int utIndex, int cellaIndex) {
		super(palya, TUNDE_START_SPEED, TUNDE_START_HP, utIndex, cellaIndex);
	}

	@Override
	protected int getSebzodes(ITorony t) {
		return t.getSebzes(ITorony.SEBZODES_TUNDE_INEDX);
	}

	@Override
	public char getMarkChar() {
		return 't';
	}

}
