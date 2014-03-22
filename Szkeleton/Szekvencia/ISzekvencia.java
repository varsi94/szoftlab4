/**
 * 
 */
package Szkeleton.Szekvencia;

/**
 * Interf�sz a szekvenci�k egys�ges kezel�s�re.
 * @author Varsi
 *
 */
public interface ISzekvencia {
	/**
	 * Ezzel a met�dussal lehet elind�tani a szekvenci�t.
	 */
	public void indit();
	
	/**
	 * Ez a met�dus adja vissza a szekvencia nev�t
	 * @return a szekvencia neve
	 */
	public String getName();
}
