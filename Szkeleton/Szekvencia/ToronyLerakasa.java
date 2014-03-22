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
 * Oszt�ly a "torony lerak�sa" szekvenci�ra.
 * @author Hanicz
 *
 */
public class ToronyLerakasa implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
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
			System.out.println("Legyen el�g var�zser�? I/N");
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
	 * Ez a met�dus adja vissza a szekvencia nev�t.
	 * @return Torony lerak�sa
	 */
	@Override
	public String getName() {
		return "Torony lerak�sa";
	}

}