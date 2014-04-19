package Ellenseg;

import Palya.Palya;
import Torony.ITorony;

public class Tunde extends Kaszt {

	private static final int TUNDE_START_HP = 8;
	private static final int TUNDE_START_SPEED = 2;

	/**
	 * Konstruktor az �t elej�r�l val� indul�shoz
	 * 
	 * @param palya
	 *            a p�lya
	 * @param utIndex
	 *            az �t indexe
	 */
	public Tunde(Palya palya, int utIndex) {
		this(palya, utIndex, 0);
	}

	/**
	 * Konstruktor ellens�g torony l�v�s duplik�ci�hoz
	 * 
	 * @param palya
	 *            a p�lya
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
		return t.getSebzes(ITorony.SEBZODES_TUNDE_INDEX);
	}

	@Override
	public char getMarkChar() {
		return 't';
	}

}
