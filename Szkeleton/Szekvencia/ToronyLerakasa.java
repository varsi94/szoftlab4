/**
 * 
 */
package Szkeleton.Szekvencia;


import java.io.IOException;

import Szkeleton.Main;
import Torony.ITorony;
import Torony.Torony;
import Palya.Palya;
import Cella.Cella;


/**
 * Osztály a "torony lerakása" szekvenciára.
 * @author Hanicz
 *
 */
public class ToronyLerakasa implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
	 */
	@Override
	public void indit() {
		ITorony t = new Torony();
		Palya p = new Palya();
		Cella c = new Cella(0,0,false);
		
		p.getVarazsero();
		int v = t.getKoltseg();
		
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
			c.setTorony(t);
			p.setVarazsero(v);
		}
		
	}

	/**
	 * Ez a metódus adja vissza a szekvencia nevét.
	 * @return Torony lerakása
	 */
	@Override
	public String getName() {
		return "Torony lerakása";
	}

}