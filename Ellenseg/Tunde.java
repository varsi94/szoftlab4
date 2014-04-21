package Ellenseg;

import Palya.Palya;
import Torony.ITorony;

/**
 * T�nd�t reprezent�l� oszt�ly
 * @author Sipka
 *
 */
public class Tunde extends Kaszt {

	private static final long serialVersionUID = -5760690146179778224L;

	/**
	 * T�nde meg�l�s��rt j�r� jutalom var�zser�.
	 */
	private static final int TUNDE_JUTALOM = 50;
	
	/**
	 * T�nde kezdeti �letpontja
	 */
	private static final int TUNDE_START_HP = 90;
	
	/**
	 * T�nde kezdeti sebess�ge, minden k�rben l�p
	 */
	private static final int TUNDE_START_SPEED = 1;

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
		jutalom = TUNDE_JUTALOM;
	}

	/**
	 * Sebz�d�s lek�rdez�se
	 * @param t Torony, amelyik l�
	 * @return sebz�d�s m�rt�ke
	 */
	@Override
	protected int getSebzodes(ITorony t) {
		return t.getSebzes(ITorony.SEBZODES_TUNDE_INDEX);
	}

	/**
	 * P�lya ki�rat�s�hoz a jel�l�
	 * @return 't'
	 */
	@Override
	public char getMarkChar() {
		return 't';
	}

	/**
	 * Kimeneti nyelvhez a kaszt neve
	 * @return "T�nde"
	 */
	@Override
	public String toString() {
		return "T�nde";
	}
}
