package Torony;

import Szkeleton.Main;

/**
 * ITorony interfész a torony által elvárt metódusok definiálására.
 * 
 * @author Varsi
 * 
 */
public interface ITorony {
	/**
	 * Amikor ez meghívódik akkor a torony megnézi hogy a hatósugarán belül lévõ cellákon van-e valaki és ha van akkor a legközelebbi ellenséget
	 * meglövi.
	 */
	public void loves();

	/**
	 * Visszaadja hogy mennyibe kerül megépíteni a tornyot
	 * 
	 * @return a költség
	 */
	public int getKoltseg();

	/**
	 * Az ellenség lekéri a sebzést amit a torony rá lõ.
	 * 
	 * @param idx
	 *            az ellenség indexe. ABC sorrendben: 0: ember, 1: hobbit, 2: torp, 3: tunde
	 * @return sebzés nagysága
	 */
	public int getSebzes(int idx);
	
	/**
	 * Sebzés növelése bizonyos ellenségre.
	 * 
	 * @param idx
	 *            az ellenség indexe. ABC sorrendben: 0: ember, 1: hobbit, 2:
	 *            torp, 3: tunde
	 * @return 
	 */
	public void setSebzes(int idx);
	
}
