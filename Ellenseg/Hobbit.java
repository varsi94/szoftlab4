package Ellenseg;

import Palya.Palya;
import Torony.ITorony;

public class Hobbit extends Kaszt {

	private static final int HOBBIT_START_HP = 3;
	private static final int HOBBIT_START_SPEED = 1;

	/**
	 * Konstruktor az �t elej�r�l val� indul�shoz
	 * 
	 * @param palya
	 *            a p�lya
	 * @param utIndex
	 *            az �t indexe
	 */
	public Hobbit(Palya palya, int utIndex) {
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
	public Hobbit(Palya palya, int utIndex, int cellaIndex) {
		super(palya, HOBBIT_START_SPEED, HOBBIT_START_HP, utIndex, cellaIndex);
	}

	@Override
	protected int getSebzodes(ITorony t) {
		return t.getSebzes(ITorony.SEBZODES_HOBBIT_INDEX);
	}

	@Override
	public char getMarkChar() {
		return 'h';
	}

}
