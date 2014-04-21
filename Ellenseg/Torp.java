package Ellenseg;

import Palya.Palya;
import Torony.ITorony;

/**
 * Törpöt reprezentáló osztály
 * @author Sipka
 *
 */
public class Torp extends Kaszt {
	private static final long serialVersionUID = -2795645610917810135L;
	
	/**
	 * A törpért kapott jutalom varázserõ.
	 */
	private static final int TORP_JUTALOM = 60;
	
	/**
	 * Törp kezdeti életpontja
	 */
	private static final int TORP_START_HP = 100;
	
	/**
	 * Törp kezdeti sebessége, hány körönként lép.
	 */
	private static final int TORP_START_SPEED = 1;

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
		jutalom = TORP_JUTALOM;
	}

	/**
	 * Sebzõdés lekérdezése
	 * @param t A torony, amelyik lõ
	 * @return a sebzõdés mértéke
	 */
	@Override
	protected int getSebzodes(ITorony t) {
		return t.getSebzes(ITorony.SEBZODES_TORP_INDEX);
	}

	/**
	 * Pálya kiíratáshoz a jelölõ 
	 * @return 'd', a T már foglalt a toronynak és a tündének
	 */
	@Override
	public char getMarkChar() {
		// Dwarf
		return 'd';
	}

	/**
	 * Kimeneti nyelvhez.
	 * @return Törp
	 */
	@Override
	public String toString() {
		return "Törp";
	}

}
