package Ellenseg;

import Palya.Palya;
import Torony.ITorony;
/**
 * Hobbitot reprezent�l� oszt�ly.
 * @author Sipka
 *
 */
public class Hobbit extends Kaszt {

	private static final long serialVersionUID = 4968626822423497401L;

	/**
	 * A hobbit�rt kapott var�zser�.
	 */
	private static final int HOBBIT_JUTALOM = 25;
	/**
	 * Hobbit kezdeti �letpontja.
	 */
	private static final int HOBBIT_START_HP = 60;
	
	/**
	 * Hobbit kezdeti sebess�ge: minden k�rben l�p.
	 */
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
		jutalom = HOBBIT_JUTALOM;
	}

	/**
	 * Sebz�d�s lek�rdez�se a toronyt�l.
	 * @param t A torony, ami l� a hobbitra
	 * @return sebz�d�s m�rt�ke
	 */
	@Override
	protected int getSebzodes(ITorony t) {
		return t.getSebzes(ITorony.SEBZODES_HOBBIT_INDEX);
	}

	/**
	 * P�lya ki�rat�s�hoz a jel�l�
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
