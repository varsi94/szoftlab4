package Varazsko;

import Torony.ITorony;

/**
 * Toronyra hat� var�zsk�vek interf�sze.
 * 
 * @author Varsi
 */
public interface ITVarazsko {
	/**
	 * Visszaadja hogy h�ny var�zser�be ker�l az adott k� haszn�lata.
	 * 
	 * @return k�lts�g
	 */
	public int getKoltseg();

	/**
	 * A f�ggv�ny megvizsg�lja hogy hathat-e toronyra. Ha igen kifejti hat�s�t.
	 * 
	 * @param t
	 *            A c�ltorony
	 * @return siker�lt-e a var�zsk� haszn�lata
	 */
	public boolean hat(ITorony t);
}
