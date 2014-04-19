package Torony;

/**
 * ITorony interfész a torony által elvárt metódusok definiálására.
 * 
 * @author Varsi
 * 
 */
public interface ITorony {
	public static final int KOLTSEG = 100;
	public static final int SEBZODES_EMBER_INDEX = 0;
	public static final int SEBZODES_HOBBIT_INDEX = 1;
	public static final int SEBZODES_TORP_INDEX = 2;
	public static final int SEBZODES_TUNDE_INEDX = 3;

	/**
	 * Amikor ez meghívódik akkor a torony megnézi hogy a hatósugarán belül lévõ cellákon van-e valaki és ha van akkor a legközelebbi ellenséget
	 * meglövi.
	 */
	public void loves();

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
	 *            az ellenség indexe. ABC sorrendben: 0: ember, 1: hobbit, 2: torp, 3: tunde
	 * @return
	 */
	public void setSebzes(int idx);

	/**
	 * Tüzelési gyakoriság növelése a toronyra
	 * 
	 * @return sikerült-e növeli a tüzelési gyakoriságot
	 */
	public boolean setTuzgyak();

	/**
	 * Megnöveli a torony hatótávolságát
	 */
	public void setHatotav();

	public boolean isKod();

	public void setKod(boolean kod);
	
	public int getTuzgyak();
	
	public int getHatotav();

}
