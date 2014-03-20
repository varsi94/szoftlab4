package Ellenseg;

import Cella.Cella;
import Torony.ITorony;

/**
 * Az interfész felelõssége hogy elõre deklarálja a késõbbi metódusokat illetve hogy képet adjon az objektum viselkedésérõl.
 * 
 * 
 */
public interface IEllenseg {
	/**
	 * Ez a függvény van meghívva amikor találat éri az objektumot. Õ lekéri sebzés nagyságát a toronytól.
	 * 
	 * @param t
	 */
	public void sebzodik(ITorony t);

	/**
	 * Ha az objektum belefut egy lassító akadályba és megáll akkor ez a függvény lesz meghívva.
	 * 
	 * @param kor
	 */
	public void megall(int kor);

	/**
	 * A léptetés ezzel a függvénnyel van megoldva.
	 * 
	 * @param c
	 */
	public void halad(Cella c);

	/**
	 * Ha az élete 0 vagy az alá csökken illetve ha belefut egy akadályba akkor ez a függvény hívódik meg.
	 */
	public void meghal();

	/**
	 * Visszaadja, hogy mekkora a sebessége
	 * 
	 * @return
	 */
	public int getSpeed();

	/**
	 * Visszaadja, hogy hány körbõl marad ki.
	 * 
	 * @return
	 */
	public int getKimarad();

	/**
	 * Visszaadja, hogy mennyi élete van a karakternek.
	 * 
	 * @return
	 */
	public int getHp();

	/**
	 * Visszaadja, az út indexének egész értékét, ahol áll éppen.
	 * 
	 * @return
	 */
	public int getUtIndex();

	/**
	 * Visszaadja a cella indexének egész értékét, ahol éppen van.
	 * 
	 * @return
	 */
	public int getCellaIndex();
}
