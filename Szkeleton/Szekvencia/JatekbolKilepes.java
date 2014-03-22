/**
 * 
 */
package Szkeleton.Szekvencia;


/**
 * Osztály a "játékból kilépés" szekvenciára.
 * @author Hanicz
 *
 */
public class JatekbolKilepes implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
	 */
	@Override
	public void indit() {
		System.out.println("System.exit(0);");
	}

	/**
	 * Ez a metódus adja vissza a szekvencia nevét.
	 * @return Játékból kilépés
	 */
	@Override
	public String getName() {
		return "Játékból kilépés";
	}

}
