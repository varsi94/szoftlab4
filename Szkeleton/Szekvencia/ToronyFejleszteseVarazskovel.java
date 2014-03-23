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
 * Oszt�ly a "torony fejleszt�se var�zsk�vel" szekvenci�ra.
 * @author Hanicz
 *
 */
public class ToronyFejleszteseVarazskovel implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
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
			System.out.println("Legyen el�g var�zser�? I/N");
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
	 * Ez a met�dus adja vissza a szekvencia nev�t.
	 * @return Torony Fejleszt�se Var�zsk�vel
	 */
	@Override
	public String getName() {
		return "Torony Fejleszt�se Var�zsk�vel";
	}

}