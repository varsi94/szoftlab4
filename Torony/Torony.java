/**
 * 
 */
package Torony;

import Szkeleton.Main;

/**
 * 
 * @author Varsi
 * 
 */
public class Torony implements ITorony {

	/**
	 * Az egyes ellenfelek elleni sebzés.
	 */
	private int[] sebzes;
	/**
	 * Hatótávolság, tüzelési gyakoriság, költség.
	 */
	private int hatotav, tuzgyak, koltseg;

	/*
	 * private Cella pozicio; private List<Cella> list;
	 */

	/**
	 * Amikor ez meghívódik akkor a torony megnézi hogy a hatósugarán belül lévõ
	 * cellákon van-e valaki és ha van akkor a legközelebbi ellenséget meglövi.
	 */
	public void loves() {
		Main.log();
	}

	/**
	 * Visszaadja hogy mennyibe kerül megépíteni a tornyot
	 * 
	 * @return a költség
	 */
	public int getKoltseg() {
		Main.log();
		return koltseg;
	}

	/**
	 * Az ellenség lekéri a sebzést amit a torony rá lõ.
	 * 
	 * @param idx
	 *            az ellenség indexe. ABC sorrendben: 0: ember, 1: hobbit, 2:
	 *            torp, 3: tunde
	 * @return sebzés nagysága
	 */
	public int getSebzes(int idx) {
		Main.log();
		return sebzes[idx];
	}

	public Torony() {
		Main.log();
		sebzes = new int[4];
	}
}
