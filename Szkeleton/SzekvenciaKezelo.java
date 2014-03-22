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
		szekvenciak.add(new UjJatek());
		szekvenciak.add(new JatekBetoltese());
		szekvenciak.add(new RanglistaMegtekintese());
		szekvenciak.add(new JatekbolKilepes());
		szekvenciak.add(new ToronyLerakasa());
		szekvenciak.add(new ToronyFejleszteseVarazskovel());
		szekvenciak.add(new AkadalyLerakasa());
		szekvenciak.add(new AkadalyFejleszteseLilaVarazskovel());
		szekvenciak.add(new UjKor());
		szekvenciak.add(new JatekMentese());
		szekvenciak.add(new ToronyEllensegreLo());
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
	 * megjelenítõ függvény
	 * @param idx a szekvencia indexe
	 */
	public void megjelenit(int idx) {
		System.out.println("-----------" + szekvenciak.get(idx).getName() + "-----------");
		szekvenciak.get(idx).indit();
	}
}
