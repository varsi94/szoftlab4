package Prototipus;

import java.util.Random;

import Ellenseg.Ember;
import Ellenseg.Hobbit;
import Ellenseg.IEllenseg;
import Ellenseg.Torp;
import Ellenseg.Tunde;
import Palya.Palya;

/**
 * Saj�t v�letlen oszt�ly
 * @author Sipka
 *
 */
public class Veletlen {
	/**
	 * Determinisztikus tesztekhez sz�ml�l�
	 */
	private static int determSzamlalo = 0;
	/**
	 * Determinisztikus �ll�t�sa.
	 */
	private static boolean determinisztikus = false;

	/**
	 * Random p�ld�ny.
	 */
	private static Random rand = new Random();

	private Veletlen() {
	}

	/**
	 * Determinisztikuss�g lek�rdez�se
	 * @return igen vagy nem
	 */
	public static final boolean isDeterminisztikus() {
		return determinisztikus;
	}

	/**
	 * Determinisztikuss�g �ll�t�sa
	 * @param determinisztikus az �j �rt�k
	 */
	public static final void setDeterminisztikus(boolean determinisztikus) {
		Veletlen.determinisztikus = determinisztikus;
	}

	/**
	 * Egy 0...n-1 k�z�tti v�letlensz�m lek�rdez�se 
	 * @param n fels� hat�r - 1
	 * @return v�letlen sz�m
	 */
	public static int nextInt(int n) {
		if (determinisztikus) {
			return determSzamlalo++ % n;
		}
		return rand.nextInt(n);
	}

	/**
	 * Dupla l�ved�k lek�rdez�se. 1/20 az es�ly
	 * @return True vagy False
	 */
	public static boolean duplaLovedek() {
		return nextInt(20) == 0;
	}
	
	/**
	 * K�d lek�rdez�se. 1/30 az es�ly
	 * @return True vagy False
	 */
	public static boolean kod(){
		return nextInt(30) == 0;
	}

	/**
	 * Random ellens�g gener�l�sa
	 * @param palya P�lya referencia
	 * @param utindex �t indexe
	 * @return az �j ellens�g
	 */
	public static IEllenseg csinaljEllenseget(Palya palya, int utindex) {
		switch (nextInt(4)) {
		case 0: {
			return new Ember(palya, utindex);
		}
		case 1: {
			return new Hobbit(palya, utindex);
		}
		case 2: {
			return new Torp(palya, utindex);
		}
		case 3: {
			return new Tunde(palya, utindex);
		}
		default: {
			throw new RuntimeException("invalid random value");
		}
		}
	}
}
