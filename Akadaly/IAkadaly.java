package Akadaly;

import Ellenseg.IEllenseg;

/**
 * Az interf�sz felel�ss�ge hogy el�re deklar�lja a k�s�bbi met�dusokat illetve hogy k�pet adjon az objektum viselked�s�r�l.
 * 
 */
public interface IAkadaly {
	/**
	 * Ez a f�ggv�ny mondja meg hogy mit tud az akad�ly csin�lni az ellenf�llel. Akkor van megh�vva ha egy ellens�g r�fut az akad�lyra.
	 * 
	 * @param e
	 *            ellens�g
	 * @return
	 */
	public boolean akadalyoz(IEllenseg e);

	/**
	 * Ha var�zsk�vel fejlesztik az akad�lyt akkor ezzel a f�ggv�nnyel n�velj�k eggyel a hat�st.
	 */
	public void fejleszt();

	/**
	 * Visszaadja hogy mennyibe ker�l lerakni egy akad�lyt.
	 * 
	 * @return a k�lts�g
	 */
	public int getKoltseg();

}
