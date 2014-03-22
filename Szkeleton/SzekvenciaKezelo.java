/**
 * 
 */
package Szkeleton;

import java.util.ArrayList;
import java.util.List;

import Szkeleton.Szekvencia.*;

/**
 * Oszt�ly a szekvenci�kat reprezent�l� objektumok t�rol�s�ra �s lek�rdez�s�re.
 * @author Varsi
 *
 */
public class SzekvenciaKezelo {
	/**
	 * a szekvenci�k list�ja
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
	 * megjelen�t� f�ggv�ny
	 * @param idx a szekvencia indexe
	 */
	public void megjelenit(int idx) {
		System.out.println(szekvenciak.get(idx).getName());
		szekvenciak.get(idx).indit();
	}
}
