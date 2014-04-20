package Prototipus;

import java.util.Random;

import Ellenseg.Ember;
import Ellenseg.Hobbit;
import Ellenseg.IEllenseg;
import Ellenseg.Torp;
import Ellenseg.Tunde;
import Palya.Palya;

public class Veletlen {
	private static int determSzamlalo = 0;
	private static boolean determinisztikus = false;

	private static Random rand = new Random();

	private Veletlen() {
	}

	public static final boolean isDeterminisztikus() {
		return determinisztikus;
	}

	public static final void setDeterminisztikus(boolean determinisztikus) {
		Veletlen.determinisztikus = determinisztikus;
	}

	public static int nextInt(int n) {
		if (determinisztikus) {
			return determSzamlalo++ % n;
		}
		return rand.nextInt(n);
	}

	public static boolean duplaLovedek() {
		return nextInt(20) == 0;
	}
	
	public static boolean kod(){
		return nextInt(30) == 0;
	}

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
