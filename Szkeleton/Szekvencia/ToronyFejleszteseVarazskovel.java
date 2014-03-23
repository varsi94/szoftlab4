/**
 * 
 */
package Szkeleton.Szekvencia;

import java.io.IOException;

import Varazsko.ITVarazsko;
import Varazsko.ZoldVarazsko;
import Palya.Palya;
import Cella.Cella;
import Szkeleton.Main;
import Torony.*;


/**
 * Osztály a "torony fejlesztése varázskõvel" szekvenciára.
 * @author Hanicz
 *
 */
public class ToronyFejleszteseVarazskovel implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
	 */
	@Override
	public void indit() {
		ITVarazsko z = new ZoldVarazsko();
		Palya p = new  Palya();
		Cella c = new Cella(0,0,false);
		ITorony t = new Torony();
		
		int v = z.getKoltseg();
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
			c.getTorony();
			z.hat(t);
			p.setVarazsero(v);
		}
	}

	/**
	 * Ez a metódus adja vissza a szekvencia nevét.
	 * @return Torony Fejlesztése Varázskõvel
	 */
	@Override
	public String getName() {
		return "Torony Fejlesztése Varázskõvel";
	}

}