package Ellenseg;

import Cella.Cella;
import Torony.ITorony;

/**
 * Az interf�sz felel�ss�ge hogy el�re deklar�lja a k�s�bbi met�dusokat illetve hogy k�pet adjon az objektum viselked�s�r�l.
 * 
 * 
 */
public interface IEllenseg {
	/**
	 * Ez a f�ggv�ny van megh�vva amikor tal�lat �ri az objektumot. � lek�ri sebz�s nagys�g�t a toronyt�l.
	 * 
	 * @param t
	 */
	public void sebzodik(ITorony t);

	/**
	 * Ha az objektum belefut egy lass�t� akad�lyba �s meg�ll akkor ez a f�ggv�ny lesz megh�vva.
	 * 
	 * @param kor
	 */
	public void megall(int kor);

	/**
	 * A l�ptet�s ezzel a f�ggv�nnyel van megoldva.
	 * 
	 * @param c
	 */
	public void halad(Cella c);

	/**
	 * Ha az �lete 0 vagy az al� cs�kken illetve ha belefut egy akad�lyba akkor ez a f�ggv�ny h�v�dik meg.
	 */
	public void meghal();

	/**
	 * Visszaadja, hogy mekkora a sebess�ge
	 * 
	 * @return
	 */
	public int getSpeed();

	/**
	 * Visszaadja, hogy h�ny k�rb�l marad ki.
	 * 
	 * @return
	 */
	public int getKimarad();

	/**
	 * Visszaadja, hogy mennyi �lete van a karakternek.
	 * 
	 * @return
	 */
	public int getHp();

	/**
	 * Visszaadja, az �t index�nek eg�sz �rt�k�t, ahol �ll �ppen.
	 * 
	 * @return
	 */
	public int getUtIndex();

	/**
	 * Visszaadja a cella index�nek eg�sz �rt�k�t, ahol �ppen van.
	 * 
	 * @return
	 */
	public int getCellaIndex();
}
