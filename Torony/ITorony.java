package Torony;

import java.io.Serializable;
import java.util.List;

import Cella.Cella;

/**
 * ITorony interf�sz a torony �ltal elv�rt met�dusok defini�l�s�ra.
 * 
 * @author Varsi
 * 
 */
public interface ITorony extends Serializable {
	/**
	 * Torony �p�t�s�hez sz�ks�ges var�zser�
	 */
	public static final int KOLTSEG = 100;
	/**
	 * Az egyes kasztokhoz tartoz� indexek konstansai.
	 */
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

	/**
	 * K�d lek�rdez�se
	 * 
	 * @return True, ha van k�d, False, ha nincs
	 */
	public boolean isKod();

	/**
	 * K�d be�ll�t�sa
	 * 
	 * @param kod
	 *            legyen vagy ne
	 */
	public void setKod(boolean kod);

	/**
	 * T�zel�sei gyakoris�g lek�rdez�se
	 * 
	 * @return t�zel�si gyakoris�g
	 */
	public int getTuzgyak();

	/**
	 * Hat�t�vols�g lek�rdez�se
	 * 
	 * @return hat�t�vols�g
	 */
	public int getHatotav();

	public List<Cella> getUtolsoLovesek();
}
