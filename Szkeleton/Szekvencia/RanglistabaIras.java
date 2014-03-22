package Szkeleton.Szekvencia;

import java.io.IOException;

import Ranglista.Ranglista;
import Szkeleton.Main;

/**
 * Oszt�ly a ranglist�ba �r�s szekvencia megval�s�t�s�ra.
 * @author Varsi
 *
 */
public class RanglistabaIras implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
	 */
	public void indit() {
		Ranglista ranglista = new Ranglista();
		System.out.println("Adja meg a nevet!");
		String name = null;
		try {
			name = Main.readString();
			ranglista.frissit(name, 45);
		} catch (IOException e) {
		}
	}

	/**
	 * Ez a met�dus adja vissza a szekvencia nev�t.
	 * @return Ranglist�ba �r�sa
	 */
	@Override
	public String getName() {
		return "Ranglist�ba �r�s";
	}

}
