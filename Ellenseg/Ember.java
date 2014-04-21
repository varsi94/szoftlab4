package Ellenseg;

import Palya.Palya;
import Torony.ITorony;

/**
 * Embert reprezent�l� oszt�ly
 * @author Sipka
 *
 */
public class Ember extends Kaszt {

	private static final long serialVersionUID = 3355684723009919840L;

	/**
	 * Az ember meg�l��s�rt j�r� var�zser�
	 */
	private static final int EMBER_JUTALOM = 40;
	
	/**
	 * Ember kezdeti �letpontja.
	 */
	private static final int EMBER_START_HP = 80;
	
	/**
	 * Ember sebess�ge: minden k�rben l�p
	 */
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
		jutalom = EMBER_JUTALOM;
	}
	
	/**
	 * Sebz�d�s lek�r�se
	 * @param t A torony, ami l� r�nk.
	 * @return A sebz�s m�rt�ke
	 */
	@Override
	protected int getSebzodes(ITorony t) {
		return t.getSebzes(ITorony.SEBZODES_EMBER_INDEX);
	}

	/**
	 * P�lya ki�rat�s�hoz a jel�l�.
	 * @return "e"
	 */
	@Override
	public char getMarkChar() {
		return 'e';
	}
	
	/**
	 * Ki�r�shoz.
	 * @return "Ember"
	 */
	@Override
	public String toString() {
		return "Ember";
	}

}
