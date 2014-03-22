/**
 * 
 */
package Szkeleton.Szekvencia;


/**
 * Oszt�ly a "j�t�kb�l kil�p�s" szekvenci�ra.
 * @author Hanicz
 *
 */
public class JatekbolKilepes implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
	 */
	@Override
	public void indit() {
		System.out.println("System.exit(0);");
	}

	/**
	 * Ez a met�dus adja vissza a szekvencia nev�t.
	 * @return J�t�kb�l kil�p�s
	 */
	@Override
	public String getName() {
		return "J�t�kb�l kil�p�s";
	}

}
