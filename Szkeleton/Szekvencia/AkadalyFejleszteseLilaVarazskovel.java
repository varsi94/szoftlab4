/**
 * 
 */
package Szkeleton.Szekvencia;

import java.io.IOException;

import Varazsko.*;
import Palya.Palya;
import Cella.Cella;
import Szkeleton.Main;
import Akadaly.*;


/**
 * Osztály az "akadály fejlesztése lila varázskõvel" szekvenciára.
 * @author Hanicz
 *
 */
public class AkadalyFejleszteseLilaVarazskovel implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
	 */
	@Override
	public void indit() {
		IAVarazsko l = new LilaVarazsko();
		Palya p = new  Palya();
		Cella c = new Cella(0,0,false);
		IAkadaly ork = new Ork(0,0, c);
		
		l.getKoltseg();
		p.getVarazsero();
		
		String s = null;
		while (s == null) {
			System.out.println("Legyen elég varázserõ? I/N");
			try {
				String tmp = Main.readString();
				if (tmp.equals("I") || tmp.equals("N"))
					s = tmp;
			} catch (IOException e) {
			}
		}
		if (s.equals("I")) {
			c.getAkadaly();
			l.hat(ork);
		}
	}

	/**
	 * Ez a metódus adja vissza a szekvencia nevét.
	 * @return Akadály fejlesztése lila varázskõvel
	 */
	@Override
	public String getName() {
		return "Akadály fejlesztése lila varázskõvel";
	}

}