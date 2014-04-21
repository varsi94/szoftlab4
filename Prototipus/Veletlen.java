package Prototipus;

import java.util.Random;

import Ellenseg.Ember;
import Ellenseg.Hobbit;
import Ellenseg.IEllenseg;
import Ellenseg.Torp;
import Ellenseg.Tunde;
import Palya.Palya;

/**
 * Saját véletlen osztály
 * @author Sipka
 *
 */
public class Veletlen {
	/**
	 * Determinisztikus tesztekhez számláló
	 */
	private static int determSzamlalo = 0;
	/**
	 * Determinisztikus állítása.
	 */
	private static boolean determinisztikus = false;

	/**
	 * Random példány.
	 */
	private static Random rand = new Random();

	private Veletlen() {
	}

	/**
	 * Determinisztikusság lekérdezése
	 * @return igen vagy nem
	 */
	public static final boolean isDeterminisztikus() {
		return determinisztikus;
	}

	/**
	 * Determinisztikusság állítása
	 * @param determinisztikus az új érték
	 */
	public static final void setDeterminisztikus(boolean determinisztikus) {
		Veletlen.determinisztikus = determinisztikus;
	}

	/**
	 * Egy 0...n-1 közötti véletlenszám lekérdezése 
	 * @param n felsõ határ - 1
	 * @return véletlen szám
	 */
	public static int nextInt(int n) {
		if (determinisztikus) {
			return determSzamlalo++ % n;
		}
		return rand.nextInt(n);
	}

	/**
	 * Dupla lövedék lekérdezése. 1/20 az esély
	 * @return True vagy False
	 */
	public static boolean duplaLovedek() {
		return nextInt(20) == 0;
	}
	
	/**
	 * Köd lekérdezése. 1/30 az esély
	 * @return True vagy False
	 */
	public static boolean kod(){
		return nextInt(30) == 0;
	}

	/**
	 * Random ellenség generálása
	 * @param palya Pálya referencia
	 * @param utindex út indexe
	 * @return az új ellenség
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
