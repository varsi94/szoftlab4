package Torony;

import Szkeleton.Main;

/**
 * ITorony interf�sz a torony �ltal elv�rt met�dusok defini�l�s�ra.
 * 
 * @author Varsi
 * 
 */
public interface ITorony {
	/**
	 * Amikor ez megh�v�dik akkor a torony megn�zi hogy a hat�sugar�n bel�l l�v� cell�kon van-e valaki �s ha van akkor a legk�zelebbi ellens�get
	 * megl�vi.
	 */
	public void loves();

	/**
	 * Visszaadja hogy mennyibe ker�l meg�p�teni a tornyot
	 * 
	 * @return a k�lts�g
	 */
	public int getKoltseg();

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
	 *            az ellens�g indexe. ABC sorrendben: 0: ember, 1: hobbit, 2:
	 *            torp, 3: tunde
	 * @return 
	 */
	public void setSebzes(int idx);
	
}
