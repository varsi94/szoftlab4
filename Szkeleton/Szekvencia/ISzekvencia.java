/**
 * 
 */
package Szkeleton.Szekvencia;

/**
 * Interfész a szekvenciák egységes kezelésére.
 * @author Varsi
 *
 */
public interface ISzekvencia {
	/**
	 * Ezzel a metódussal lehet elindítani a szekvenciát.
	 */
	public void indit();
	
	/**
	 * Ez a metódus adja vissza a szekvencia nevét
	 * @return a szekvencia neve
	 */
	public String getName();
}
