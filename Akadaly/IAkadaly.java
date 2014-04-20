package Akadaly;

import java.io.Serializable;

import Cella.Cella;
import Ellenseg.IEllenseg;

/**
 * Az interfész felelõssége hogy elõre deklarálja a késõbbi metódusokat illetve hogy képet adjon az objektum viselkedésérõl.
 * 
 */
public interface IAkadaly extends Serializable {
	/**
	 * Ez a függvény mondja meg hogy mit tud az akadály csinálni az ellenféllel. Akkor van meghívva ha egy ellenség ráfut az akadályra.
	 * 
	 * @param e
	 *            ellenség
	 * @return hogy az akadály még létezik-e az akadály
	 */
	public boolean akadalyoz(IEllenseg e);

	/**
	 * Ha varázskõvel fejlesztik az akadályt akkor ezzel a függvénnyel növeljük eggyel a hatást.
	 */
	public void fejleszt();

	/**
	 * Visszaadja hogy mennyibe kerül lerakni egy akadályt.
	 * 
	 * @return a költség
	 */
	public int getKoltseg();

	public Cella getCella();
	
	public int getHatas();
	

}
