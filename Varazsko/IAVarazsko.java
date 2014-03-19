package Varazsko;

import Akadaly.IAkadaly;

/**
 * Az interf�sz felel�ss�ge hogy egys�get alkosson a var�zsk�vek k�z�tt, hogy
 * lehessen rajta kereszt�l egy b�rmilyen t�pus�ra hivatkozni ami akad�lyra hat.
 * 
 * @author Varsi
 * 
 */
public interface IAVarazsko {
	/**
	 * Visszaadja hogy h�ny var�zser�be ker�l az adott k� haszn�lata
	 * @return
	 */
	public int getKoltseg();
	/**
	 * A f�ggv�ny megvizsg�lja hogy hathat-e akad�lyra. Ha igen kifejti hat�s�t.
	 * @param a c�lakadaly
	 * @return siker�lt-e a m�velet
	 */
	public boolean hat(IAkadaly a);
}
