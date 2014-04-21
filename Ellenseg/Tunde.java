package Ellenseg;

import Palya.Palya;
import Torony.ITorony;

/**
 * Tündét reprezentáló osztály
 * @author Sipka
 *
 */
public class Tunde extends Kaszt {

	private static final long serialVersionUID = -5760690146179778224L;

	/**
	 * Tünde megöléséért járó jutalom varázserõ.
	 */
	private static final int TUNDE_JUTALOM = 50;
	
	/**
	 * Tünde kezdeti életpontja
	 */
	private static final int TUNDE_START_HP = 90;
	
	/**
	 * Tünde kezdeti sebessége, minden körben lép
	 */
	private static final int TUNDE_START_SPEED = 1;

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
		jutalom = TUNDE_JUTALOM;
	}

	/**
	 * Sebzõdés lekérdezése
	 * @param t Torony, amelyik lõ
	 * @return sebzõdés mértéke
	 */
	@Override
	protected int getSebzodes(ITorony t) {
		return t.getSebzes(ITorony.SEBZODES_TUNDE_INDEX);
	}

	/**
	 * Pálya kiíratásához a jelölõ
	 * @return 't'
	 */
	@Override
	public char getMarkChar() {
		return 't';
	}

	/**
	 * Kimeneti nyelvhez a kaszt neve
	 * @return "Tünde"
	 */
	@Override
	public String toString() {
		return "Tünde";
	}
}
