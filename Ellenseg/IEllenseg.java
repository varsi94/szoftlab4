package Ellenseg;

import java.io.Serializable;

import Torony.ITorony;

/**
 * Az interf�sz felel�ss�ge hogy el�re deklar�lja a k�s�bbi met�dusokat illetve hogy k�pet adjon az objektum viselked�s�r�l.
 * 
 * 
 */
public interface IEllenseg extends Cloneable, Serializable {
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
	public void halad();

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

	/**
	 * HP fel�l�r�sa
	 * @param hp �j hp
	 */
	public void setHp(int hp);

	/**
	 * Ellens�g k�tszerez�s�hez a clone met�dus
	 * @return m�solat
	 */
	public IEllenseg clone();

	/**
	 * Debug-ra visszaadja a t�rk�pen milyen karakterk�nt jelenjen meg
	 * 
	 * @return a karakter
	 */
	public char getMarkChar();
	
	/**
	 * Visszaadja, hogy �ppen lass�tva van-e az ellens�g.
	 * @return igaz vagy hamis
	 */
	public boolean isLassitott();
}
