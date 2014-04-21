package Ellenseg;

import Palya.Palya;
import Torony.ITorony;
/**
 * Hobbitot reprezentáló osztály.
 * @author Sipka
 *
 */
public class Hobbit extends Kaszt {

	private static final long serialVersionUID = 4968626822423497401L;

	/**
	 * A hobbitért kapott varázserõ.
	 */
	private static final int HOBBIT_JUTALOM = 25;
	/**
	 * Hobbit kezdeti életpontja.
	 */
	private static final int HOBBIT_START_HP = 60;
	
	/**
	 * Hobbit kezdeti sebessége: minden körben lép.
	 */
	private static final int HOBBIT_START_SPEED = 1;

	/**
	 * Konstruktor az út elejérõl való induláshoz
	 * 
	 * @param palya
	 *            a pálya
	 * @param utIndex
	 *            az út indexe
	 */
	public Hobbit(Palya palya, int utIndex) {
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
	public Hobbit(Palya palya, int utIndex, int cellaIndex) {
		super(palya, HOBBIT_START_SPEED, HOBBIT_START_HP, utIndex, cellaIndex);
		jutalom = HOBBIT_JUTALOM;
	}

	/**
	 * Sebzõdés lekérdezése a toronytól.
	 * @param t A torony, ami lõ a hobbitra
	 * @return sebzõdés mértéke
	 */
	@Override
	protected int getSebzodes(ITorony t) {
		return t.getSebzes(ITorony.SEBZODES_HOBBIT_INDEX);
	}

	/**
	 * Pálya kiíratásához a jelölõ
	 * @return "h"
	 */
	@Override
	public char getMarkChar() {
		return 'h';
	}

	/**
	 * Kimeneti nyelvhez
	 * @return "Hobbit"
	 */
	@Override
	public String toString() {
		return "Hobbit";
	}
	
}
