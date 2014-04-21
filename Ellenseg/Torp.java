package Ellenseg;

import Palya.Palya;
import Torony.ITorony;

/**
 * T�rp�t reprezent�l� oszt�ly
 * @author Sipka
 *
 */
public class Torp extends Kaszt {
	private static final long serialVersionUID = -2795645610917810135L;
	
	/**
	 * A t�rp�rt kapott jutalom var�zser�.
	 */
	private static final int TORP_JUTALOM = 60;
	
	/**
	 * T�rp kezdeti �letpontja
	 */
	private static final int TORP_START_HP = 100;
	
	/**
	 * T�rp kezdeti sebess�ge, h�ny k�r�nk�nt l�p.
	 */
	private static final int TORP_START_SPEED = 1;

	/**
	 * Konstruktor az �t elej�r�l val� indul�shoz
	 * 
	 * @param palya
	 *            a p�lya
	 * @param utIndex
	 *            az �t indexe
	 */
	public Torp(Palya palya, int utIndex) {
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
	public Torp(Palya palya, int utIndex, int cellaIndex) {
		super(palya, TORP_START_SPEED, TORP_START_HP, utIndex, cellaIndex);
		jutalom = TORP_JUTALOM;
	}

	/**
	 * Sebz�d�s lek�rdez�se
	 * @param t A torony, amelyik l�
	 * @return a sebz�d�s m�rt�ke
	 */
	@Override
	protected int getSebzodes(ITorony t) {
		return t.getSebzes(ITorony.SEBZODES_TORP_INDEX);
	}

	/**
	 * P�lya ki�rat�shoz a jel�l� 
	 * @return 'd', a T m�r foglalt a toronynak �s a t�nd�nek
	 */
	@Override
	public char getMarkChar() {
		// Dwarf
		return 'd';
	}

	/**
	 * Kimeneti nyelvhez.
	 * @return T�rp
	 */
	@Override
	public String toString() {
		return "T�rp";
	}

}
