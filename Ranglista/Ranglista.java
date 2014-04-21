package Ranglista;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Osztály a ranglista tárolására
 * 
 * @author Sipka
 * 
 */
public class Ranglista implements Serializable {
	private static final long serialVersionUID = 1242587070802683790L;
	/**
	 * Ebben vannak az adatok.
	 */
	private Map<String, Integer> lista = new HashMap<String, Integer>();

	/**
	 * Ezzel a metódussal tudjuk frissíteni
	 * 
	 * @param name
	 *            játékos neve
	 * @param ido
	 *            játék ideje
	 */
	public void frissit(String name, int pontszam) {
		lista.put(name, pontszam);
	}

	/**
	 * Kiírjuk a ranglistát
	 */
	public void kiir() {
		for (Entry<String, Integer> e : lista.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}

	/**
	 * Konstruktor
	 */
	public Ranglista() {
	}
	
	/**
	 * Ranglista mentése
	 */
	public void szerializalas(){
		try {
			String path = System.getProperty("user.dir") + "\\";
			File f1 = new File(path + "ranglista.ser");
			f1.delete();
			FileOutputStream fileOut = new FileOutputStream("ranglista.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			System.out.println("Nem sikerült a mentés!");
		}
	}

}
