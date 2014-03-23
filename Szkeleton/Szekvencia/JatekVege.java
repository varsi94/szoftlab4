/**
 * 
 */
package Szkeleton.Szekvencia;

import java.io.IOException;

import Palya.Palya;
import Szkeleton.Main;

/**
 * Oszt�ly a "j�t�k v�ge" szekvencia �br�zol�s�ra.
 * @author Varsi
 *
 */
public class JatekVege implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
	 */
	public void indit() {
		Palya p = new Palya();
		String s = null;
		while (s == null) {
			System.out.println("Vesz�tsen a j�t�kos? I/N");
			try {
				String tmp = Main.readString();
				if (tmp.equals("I") || tmp.equals("N"))
					s = tmp;
			} catch (IOException e) {
			}
		}
		if (s.equals("I"))
			p.lost();
		else
			p.win();
	}

	/**
	 * Ez a met�dus adja vissza a szekvencia nev�t.
	 * @return J�t�k v�ge
	 */
	public String getName() {
		return "J�t�k v�ge";
	}

}
