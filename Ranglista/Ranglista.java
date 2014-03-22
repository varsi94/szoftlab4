package Ranglista;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import Szkeleton.Main;

/**
 * Osztály a ranglista tárolására
 * @author Sipka
 *
 */
public class Ranglista {
	/**
	 * Ebben vannak az adatok.
	 */
	private Map<String, Integer> lista = new HashMap<String, Integer>();

	/**
	 * Ezzel a metódussal tudjuk frissíteni
	 * @param name játékos neve
	 * @param ido játék ideje
	 */
	public void frissit(String name, int ido) {
		Main.log();
		lista.put(name, ido);
	}

	/**
	 * Kiírjuk a ranglistát
	 */
	public void kiir() {
		Main.log();
		for (Entry<String, Integer> e : lista.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}
	
	/**
	 * Konstruktor
	 */
	public Ranglista(){
		Main.log();
	}

}
