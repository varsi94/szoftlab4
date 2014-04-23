package Varazsko;

import Torony.ITorony;

/**
 * Toronyra hat� var�zsk�vek interf�sze.
 * 
 * @author Varsi
 */
public interface ITVarazsko {

	/**
	 * A f�ggv�ny megvizsg�lja hogy hathat-e toronyra. Ha igen kifejti hat�s�t.
	 * 
	 * @param t
	 *            A c�ltorony
	 * @return siker�lt-e a var�zsk� haszn�lata
	 */
	public boolean hat(ITorony t);
}
