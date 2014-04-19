package Torony;

/**
 * ITorony interf�sz a torony �ltal elv�rt met�dusok defini�l�s�ra.
 * 
 * @author Varsi
 * 
 */
public interface ITorony {
	public static final int KOLTSEG = 100;
	public static final int SEBZODES_EMBER_INDEX = 0;
	public static final int SEBZODES_HOBBIT_INDEX = 1;
	public static final int SEBZODES_TORP_INDEX = 2;
	public static final int SEBZODES_TUNDE_INDEX = 3;

	/**
	 * Amikor ez megh�v�dik akkor a torony megn�zi hogy a hat�sugar�n bel�l l�v� cell�kon van-e valaki �s ha van akkor a legk�zelebbi ellens�get
	 * megl�vi.
	 */
	public void loves();

	/**
	 * Az ellens�g lek�ri a sebz�st amit a torony r� l�.
	 * 
	 * @param idx
	 *            az ellens�g indexe. ABC sorrendben: 0: ember, 1: hobbit, 2: torp, 3: tunde
	 * @return sebz�s nagys�ga
	 */
	public int getSebzes(int idx);

	/**
	 * Sebz�s n�vel�se bizonyos ellens�gre.
	 * 
	 * @param idx
	 *            az ellens�g indexe. ABC sorrendben: 0: ember, 1: hobbit, 2: torp, 3: tunde
	 * @return
	 */
	public void setSebzes(int idx);

	/**
	 * T�zel�si gyakoris�g n�vel�se a toronyra
	 * 
	 * @return siker�lt-e n�veli a t�zel�si gyakoris�got
	 */
	public boolean setTuzgyak();

	/**
	 * Megn�veli a torony hat�t�vols�g�t
	 */
	public void setHatotav();

	public boolean isKod();

	public void setKod(boolean kod);
	
	public int getTuzgyak();
	
	public int getHatotav();
	
	public int getKoltseg();
}
