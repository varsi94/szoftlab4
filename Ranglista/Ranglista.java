package Ranglista;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Oszt�ly a ranglista t�rol�s�ra
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
	 * Ezzel a met�dussal tudjuk friss�teni
	 * 
	 * @param name
	 *            j�t�kos neve
	 * @param ido
	 *            j�t�k ideje
	 */
	public void frissit(String name, int ido) {
		lista.put(name, ido);
	}

	/**
	 * Ki�rjuk a ranglist�t
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

}
