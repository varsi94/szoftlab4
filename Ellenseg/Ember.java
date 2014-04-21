package Ellenseg;

import Palya.Palya;
import Torony.ITorony;

public class Ember extends Kaszt {
	private static final long serialVersionUID = 3355684723009919840L;
	private static final int EMBER_START_HP = 80;
	private static final int EMBER_START_SPEED = 1;

	/**
	 * Konstruktor az �t elej�r�l val� indul�shoz
	 * 
	 * @param palya
	 *            a p�lya
	 * @param utIndex
	 *            az �t indexe
	 */
	public Ember(Palya palya, int utIndex) {
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
