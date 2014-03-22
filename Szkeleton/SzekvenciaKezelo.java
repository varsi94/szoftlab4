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
		szekvenciak.add(null);
		szekvenciak.add(null);
		szekvenciak.add(null);
		szekvenciak.add(null);
		szekvenciak.add(null);
		szekvenciak.add(null);
		szekvenciak.add(null);
		szekvenciak.add(null);
		szekvenciak.add(null);
		szekvenciak.add(null);
		szekvenciak.add(null);
		szekvenciak.add(new EllensegSebzodik());
		szekvenciak.add(new EllensegElpusztul());
		szekvenciak.add(new AkadalyElpusztitjaEllenseget());
		szekvenciak.add(new AkadalyEltunik());
		szekvenciak.add(new AkadalyLelassit());
		szekvenciak.add(new EllensegLelassitasa());
		szekvenciak.add(new EllensegLeptetese());
		szekvenciak.add(new EllensegEleriHegyet());
		szekvenciak.add(new JatekVege());
		szekvenciak.add(new RanglistabaIras());
	}
	
	/**
	 * megjelen�t� f�ggv�ny
	 * @param idx a szekvencia indexe
	 */
	public void megjelenit(int idx) {
		System.out.println("-----------" + szekvenciak.get(idx).getName() + "-----------");
		szekvenciak.get(idx).indit();
	}
}
