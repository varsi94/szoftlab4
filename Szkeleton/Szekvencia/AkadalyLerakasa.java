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
 * Osztály az "akadály lerakása" szekvenciára.
 * @author Hanicz
 *
 */
public class AkadalyLerakasa implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
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
			System.out.println("Legyen elég varázserõ? I/N");
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
	 * Ez a metódus adja vissza a szekvencia nevét.
	 * @return Akadály lerakása
	 */
	@Override
	public String getName() {
		return "Akadály lerakása";
	}

}