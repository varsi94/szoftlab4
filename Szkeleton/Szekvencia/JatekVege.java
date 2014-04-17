/**
 * 
 */
package Szkeleton.Szekvencia;

import java.io.IOException;

import Palya.Palya;
import Szkeleton.Main;

/**
 * Osztály a "játék vége" szekvencia ábrázolására.
 * @author Varsi
 *
 */
public class JatekVege implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
	 */
	public void indit() {
		Palya p = new Palya();
		String s = null;
		while (s == null) {
			System.out.println("Veszítsen a játékos? I/N");
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
	 * Ez a metódus adja vissza a szekvencia nevét.
	 * @return Játék vége
	 */
	public String getName() {
		return "Játék vége";
	}

}
