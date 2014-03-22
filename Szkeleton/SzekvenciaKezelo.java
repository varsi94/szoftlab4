/**
 * 
 */
package Szkeleton;

import java.util.ArrayList;
import java.util.List;

import Szkeleton.Szekvencia.*;

/**
 * Osztály a szekvenciákat reprezentáló objektumok tárolására és lekérdezésére.
 * @author Varsi
 *
 */
public class SzekvenciaKezelo {
	/**
	 * a szekvenciák listája
	 */
	private List<ISzekvencia> szekvenciak;
	
	/**
	 * Konstruktor
	 */
	public SzekvenciaKezelo() {
		szekvenciak = new ArrayList<ISzekvencia>();
		for (int i = 0; i < 21; i++) {
			szekvenciak.add(new EllensegSebzodik());
		}
	}
	
	/**
	 * megjelenítõ függvény
	 * @param idx a szekvencia indexe
	 */
	public void megjelenit(int idx) {
		System.out.println(szekvenciak.get(idx).getName());
		szekvenciak.get(idx).indit();
	}
}
