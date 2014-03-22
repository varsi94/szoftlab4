package Szkeleton.Szekvencia;

import java.io.IOException;

import Ranglista.Ranglista;
import Szkeleton.Main;

/**
 * Osztály a ranglistába írás szekvencia megvalósítására.
 * @author Varsi
 *
 */
public class RanglistabaIras implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
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
	 * Ez a metódus adja vissza a szekvencia nevét.
	 * @return Ranglistába írása
	 */
	@Override
	public String getName() {
		return "Ranglistába írás";
	}

}
