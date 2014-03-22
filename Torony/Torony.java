/**
 * 
 */
package Torony;

import Ellenseg.Ember;
import Ellenseg.IEllenseg;
import Szkeleton.Main;

/**
 * 
 * @author Varsi
 * 
 */
public class Torony implements ITorony {

	/**
	 * Az egyes ellenfelek elleni sebz�s.
	 */
	private int[] sebzes;
	/**
	 * Hat�t�vols�g.
	 */
	private int hatotav;
	/**
	 * T�zel�si gyakoris�g
	 */
	private int tuzgyak;
	/**
	 * K�lts�g.
	 */
	private int koltseg;

	/*
	 * private Cella pozicio; private List<Cella> list;
	 */

	/**
	 * Amikor ez megh�v�dik akkor a torony megn�zi hogy a hat�sugar�n bel�l l�v�
	 * cell�kon van-e valaki �s ha van akkor a legk�zelebbi ellens�get megl�vi.
	 */
	@Override
	public void loves() {
		Main.log();
		IEllenseg ember = new Ember();
		ember.sebzodik(this);
	}

	/**
	 * Visszaadja hogy mennyibe ker�l meg�p�teni a tornyot
	 * 
	 * @return a k�lts�g
	 */
	@Override
	public int getKoltseg() {
		Main.log();
		return koltseg;
	}

	/**
	 * Az ellens�g lek�ri a sebz�st amit a torony r� l�.
	 * 
	 * @param idx
	 *            az ellens�g indexe. ABC sorrendben: 0: ember, 1: hobbit, 2:
	 *            torp, 3: tunde
	 * @return sebz�s nagys�ga
	 */
	@Override
	public int getSebzes(int idx) {
		Main.log();
		return sebzes[idx];
	}

	public Torony() {
		Main.log();
		sebzes = new int[4];
	}
}
