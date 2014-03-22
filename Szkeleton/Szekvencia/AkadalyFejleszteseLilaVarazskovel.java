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
 * Oszt�ly az "akad�ly fejleszt�se lila var�zsk�vel" szekvenci�ra.
 * @author Hanicz
 *
 */
public class AkadalyFejleszteseLilaVarazskovel implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
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
			System.out.println("Legyen el�g var�zser�? I/N");
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
	 * Ez a met�dus adja vissza a szekvencia nev�t.
	 * @return Akad�ly fejleszt�se lila var�zsk�vel
	 */
	@Override
	public String getName() {
		return "Akad�ly fejleszt�se lila var�zsk�vel";
	}

}