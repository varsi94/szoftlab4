/**
 * 
 */
package Szkeleton.Szekvencia;


import java.io.IOException;

import Szkeleton.Main;
import Palya.Palya;
import Cella.Cella;
import Akadaly.*;


/**
 * Oszt�ly az "akad�ly lerak�sa" szekvenci�ra.
 * @author Hanicz
 *
 */
public class AkadalyLerakasa implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
	 */
	@Override
	public void indit() {
		IAkadaly ork = new Ork(0,0);
		Palya p = new Palya();
		Cella c = new Cella(0,0,false);
		
		p.getVarazsero();
		int v = ork.getKoltseg();
		
		
		String s = null;
		while (s == null) {
			System.out.println("Legyen el�g var�zser�? I/N");
			try {
				String tmp = Main.readString();
				if (tmp.equals("I") || tmp.equals("N"))
					s = tmp;
			} catch (IOException e) {
			}
		}
		if (s.equals("I")) {
			c.setAkadaly(ork);
			p.setVarazsero(v);
		}
		
	}

	/**
	 * Ez a met�dus adja vissza a szekvencia nev�t.
	 * @return Akad�ly lerak�sa
	 */
	@Override
	public String getName() {
		return "Akad�ly lerak�sa";
	}

}